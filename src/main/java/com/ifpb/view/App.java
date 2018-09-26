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

        //Part 1 - Save user
        dao.saveUser(new Usuario(1, "João", "joao@mail.com", "pass1",
                LocalDate.now(), LocalDate.now()));
        dao.saveUser(new Usuario(2, "Maria", "maria@mail.com", "pass2",
                LocalDate.now(), LocalDate.now()));
        dao.saveUser(new Usuario(3, "Pedro", "pedro@mail.com", "pass3",
                LocalDate.now(), LocalDate.now()));
        dao.saveUser(new Usuario(4, "Fulano", "fulano@mail.com", "pass4",
                LocalDate.now(), LocalDate.now()));
        dao.saveUser(new Usuario(5, "Katarina", "katarina@mail.com", "pass5",
                LocalDate.now(), LocalDate.now()));
        dao.saveUser(new Usuario(6, "Frodo", "frodo@mail.com", "pass6",
                LocalDate.now(), LocalDate.now()));
        dao.saveUser(new Usuario(7, "Goku", "goku@mail.com", "pass7",
                LocalDate.now(), LocalDate.now()));

        //Part 2 - Friedship
        dao.friendship(new Amigo(2, 4, LocalDate.now()));
        dao.friendship(new Amigo(2, 3, LocalDate.now()));
        dao.friendship(new Amigo(2, 5, LocalDate.now()));
        dao.friendship(new Amigo(5, 1, LocalDate.now()));
        dao.friendship(new Amigo(5, 2, LocalDate.now()));
        dao.friendship(new Amigo(5, 6, LocalDate.now()));
        dao.friendship(new Amigo(6, 5, LocalDate.now()));
        dao.friendship(new Amigo(2, 1, LocalDate.now()));

        //Part 3 - Save publish
        dao.savePost(new Publicacao("Katarina", 1, 5,
                "Olá, meu nome pe Katarina.", LocalDate.now()));
        dao.savePost(new Publicacao("Katarina", 2, 5,
                "Minha segunda publicação, que legal!!.", LocalDate.now()));
        dao.savePost(new Publicacao("Frodo", 3, 6,
                "Eu salvei a Terra-Média.", LocalDate.now()));
        dao.savePost(new Publicacao("Maria", 4, 2,
                "Em um relacionamento sério com João <3", LocalDate.now()));
        dao.savePost(new Publicacao("Frodo", 5, 6,
                "Em direção a Mordor !!! #TerraMedia #Hobbit", LocalDate.now()));
        dao.savePost(new Publicacao("João", 6, 1,
                "Pensando em alguma coisa...", LocalDate.now()));
        dao.savePost(new Publicacao("Goku", 7, 7,
                "Oi, eu sou Goku@", LocalDate.now()));


        //Part 4 - Seguidor another user
        dao.follow(new Seguidor(1, 7, LocalDate.now()));
        dao.follow(new Seguidor(7, 2, LocalDate.now()));
        dao.follow(new Seguidor(5, 3, LocalDate.now()));
        dao.follow(new Seguidor(1, 6, LocalDate.now()));
        dao.follow(new Seguidor(4, 6, LocalDate.now()));

        //Part5 - Find friends of friend
        dao.findFriendsOfFriend("katarina@mail.com");
        dao.findFriendsOfFriend("maria@mail.com");
        dao.findFriendsOfFriend("frodo@mail.com");

        //Part 6 - Unfriend
        dao.unfriend(new Amigo(6, 5, null));

        //Part 4 - Unfollow another user
        dao.unfollow(new Seguidor(5, 3, null));

        try{
            dao.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
