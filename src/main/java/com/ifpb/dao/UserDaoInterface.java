package com.ifpb.dao;

import com.ifpb.model.Amigo;
import com.ifpb.model.Seguidor;
import com.ifpb.model.Publicacao;
import com.ifpb.model.Usuario;

public interface UserDaoInterface {
    boolean salvarUsuario(Usuario usuario);
    boolean amizade(Amigo amizade);
    boolean desAmizade(Amigo amizade);
    void encontrarAmigo(String email);
    boolean salvarPost(Publicacao publicacao);
    boolean seguir(Seguidor seguidor);
    boolean desSeguir(Seguidor seguidor);

    void close() throws Exception;

}
