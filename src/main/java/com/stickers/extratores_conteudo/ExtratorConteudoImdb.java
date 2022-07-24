package com.stickers.extratores_conteudo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.stickers.JsonParser;
import com.stickers.Entities.Conteudo;

public class ExtratorConteudoImdb implements ExtratorConteudo {
    public List<Conteudo> extariConteudos(String json) {
        // extrair somente os dados que interessam (titulo, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title").replaceAll("[://\\_$#@%]", " ");
            String urlImagem = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");

            Conteudo conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;
    }

}
