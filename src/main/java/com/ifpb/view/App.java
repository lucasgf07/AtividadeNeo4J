package com.ifpb.view;

import com.ifpb.model.Amigo;
import com.ifpb.model.Publicacao;
import com.ifpb.model.Seguidor;
import com.ifpb.model.Usuario;
import com.ifpb.dao.impl.UserDao;

import java.time.LocalDate;


public class App {
    public static void main(String[] args) {
        UserDao dao = new UserDao();

        //Part 1 - Salvar Usuario
        dao.salvarUsuario(new Usuario(1, "João", "joao@gmail.com", "123"));

        dao.salvarUsuario(new Usuario(2, "Maria", "maria@gmail.com", "123456"));

        dao.salvarUsuario(new Usuario(3, "Paulo", "paulo@hotmail.com", "321"));

        dao.salvarUsuario(new Usuario(4, "Ana", "ana@hotmail.com", "654321"));
        
        dao.salvarUsuario(new Usuario(5, "Pedro", "pedro@gmail.com", "1234"));

        //Part 2 - Salvar amizade
        dao.amizade(new Amigo(2, 4, LocalDate.now()));
        dao.amizade(new Amigo(2, 3, LocalDate.now()));
        dao.amizade(new Amigo(2, 5, LocalDate.now()));
        dao.amizade(new Amigo(5, 1, LocalDate.now()));
        dao.amizade(new Amigo(5, 2, LocalDate.now()));
        dao.amizade(new Amigo(2, 1, LocalDate.now()));

        //Part 3 - Salvar publicação
        dao.salvarPost(new Publicacao("Ana", 1, 4,
                "Olá, meu nome é Ana.", LocalDate.now()));
        dao.salvarPost(new Publicacao("Ana", 2, 4,
                "Acabei de comer uma pizza!", LocalDate.now()));
        dao.salvarPost(new Publicacao("Pedro", 3, 5,
                "GG!", LocalDate.now()));
        dao.salvarPost(new Publicacao("Maria", 4, 2,
                "Em um relacionamento sério com João!!", LocalDate.now()));
        dao.salvarPost(new Publicacao("Paulo", 5, 3,
                "Novo cham do LOL está bem \"balanceado\"", LocalDate.now()));
        dao.salvarPost(new Publicacao("João", 6, 1,
                "Pronto para viagem", LocalDate.now()));
        


        //Part 4 - Seguidor
        dao.seguir(new Seguidor(1, 5, LocalDate.now()));
        dao.seguir(new Seguidor(2, 3, LocalDate.now()));
        dao.seguir(new Seguidor(5, 3, LocalDate.now()));
        dao.seguir(new Seguidor(1, 4, LocalDate.now()));
        dao.seguir(new Seguidor(4, 1, LocalDate.now()));

        //Part5 - Encontrar Amigo
        dao.encontrarAmigo("Ana@hotmail.com");
        dao.encontrarAmigo("maria@gmail.com");
        dao.encontrarAmigo("Pedro@gmail.com");

        //Part 6 - desfazer amizade
        dao.desAmizade(new Amigo(2, 4, null));

        //Part 4 - desfazer seguir
        dao.desSeguir(new Seguidor(1, 4, null));

        try{
            dao.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
