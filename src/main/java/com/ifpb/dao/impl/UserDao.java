package com.ifpb.dao.impl;

import com.ifpb.database.DriverFactory;
import com.ifpb.model.Seguidor;
import com.ifpb.model.Amigo;
import com.ifpb.model.Publicacao;
import com.ifpb.model.Usuario;
import com.ifpb.dao.UserDaoInterface;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;
import org.neo4j.driver.v1.exceptions.ClientException;

import static org.neo4j.driver.v1.Values.parameters;

public class UserDao implements UserDaoInterface {

    private Driver driver;
    private Session session;

    public UserDao() {
        driver = new DriverFactory().getDriver();
        session = driver.session();
    }

    @Override
    public boolean salvarUsuario(Usuario usuario) {
        int cont;
        try (Transaction tx = session.beginTransaction()) {
            StatementResult result = tx.run(
                    "CREATE (:Usuario{id:$id, nome:$nome, email:$email, senha:$senha, birthday:$birthday, join_date:$join_date})",
                    parameters("id", usuario.getId(),
                                              "nome", usuario.getNome(),
                                              "email", usuario.getEmail(),
                                              "senha", usuario.getSenha()));

            tx.success();

            cont = result.summary().counters().nodesCreated();
        }catch (ClientException ex){
            return false;
        }
        return cont > 0;
    }

    @Override
    public boolean amizade(Amigo amizade) {
        int cont;
        try (Transaction tx = session.beginTransaction()) {
            StatementResult result = tx.run(
                    "MATCH (x:Usuario), (y:Usuario) WHERE x.id = $id1 AND y.id = $id2 " +
                            "CREATE (x)-[f:FRIEND{since:$since}]->(y) " +
                            "RETURN x,f,y",
                    parameters("id1", amizade.getIdAmigo(),
                                              "id2", amizade.getIdAmigo2(),
                                              "data", amizade.getData()));

            tx.success();

            cont = result.summary().counters().nodesCreated();
        }catch (ClientException ex){
            return false;
        }
        return cont > 0;
    }

    @Override
    public boolean desAmizade(Amigo amizade) {
        int cont;
        try (Transaction tx = session.beginTransaction()) {
            StatementResult result = tx.run(
                    "MATCH (:Usuario{id:$id1})-[r:FRIEND]->(:Usuario{id:$id2}) DELETE r",
                    parameters("id1", amizade.getIdAmigo(),
                            "id2", amizade.getIdAmigo2()));

            tx.success();

            cont = result.summary().counters().nodesCreated();
        }catch (ClientException ex){
            return false;
        }
        return cont > 0;
    }

    @Override
    public boolean salvarPost(Publicacao publicacao) {
        int cont;
        try (Transaction tx = session.beginTransaction()) {
            StatementResult result = tx.run("MATCH (u:Usuario{nome:$nome}) " +
                                               "CREATE (u)-[:POSTED]->(:Publicacao{id:$idPublicacao, idUsuario:$idUsuario, " +
                                               "conteudo:$conteudo, data:$data})",
                    parameters("nome", publicacao.getNomeUsuario(),
                                              "idPublicacao", publicacao.getIdPublicacao(),
                                              "idUsuario", publicacao.getIdUsuario(),
                                              "conteudo", publicacao.getConteudo(),
                                              "data", publicacao.getData()));

            tx.success();

            cont = result.summary().counters().nodesCreated();
        }catch (ClientException ex){
            return false;
        }
        return cont > 0;
    }

    @Override
    public boolean seguir(Seguidor seguidor) {
        int cont;
        try (Transaction tx = session.beginTransaction()) {
            StatementResult result = tx.run(
                    "MATCH (x:Usuario), (y:Usuario) WHERE x.id = $seguirer AND y.id = $seguired " +
                            "CREATE (x)-[f:seguir{since:$since}]->(y) " +
                            "RETURN x,f,y",
                    parameters("seguirer", seguidor.getSeguidor(),
                            "seguired", seguidor.getUsuario(),
                            "since", seguidor.getSince()));

            tx.success();

            cont = result.summary().counters().nodesCreated();
        }catch (ClientException ex){
            return false;
        }
        return cont > 0;
    }

    @Override
    public boolean desSeguir(Seguidor seguidor) {
        int cont;
        try (Transaction tx = session.beginTransaction()) {
            StatementResult result = tx.run(
                    "MATCH (:Usuario{id:$id1})-[r:seguir]->(:Usuario{id:$id2}) DELETE r",
                    parameters("id1", seguidor.getSeguidor(),
                            "id2", seguidor.getUsuario()));

            tx.success();

            cont = result.summary().counters().nodesCreated();
        }catch (ClientException ex){
            return false;
        }
        return cont > 0;
    }


    @Override
    public void encontrarAmigo(String email) {
        try (Transaction tx = session.beginTransaction()) {
            StatementResult result = tx.run(
                     "MATCH (u:Usuario)-[:FRIEND]->(:Usuario)-[:FRIEND]->(friends:Usuario) " +
                        "WHERE u.email = $email " +
                        "RETURN friends.email ",
                    parameters("email", email));

            if (result.hasNext()) {
                System.out.println("\nFRIENDS OF FRIENDS (EMAIL):");
                do System.out.println(result.next().values().toString());
                while(true);
            } else {
                System.out.println("No friends of friend!\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        session.close();
        driver.close();
    }
}
