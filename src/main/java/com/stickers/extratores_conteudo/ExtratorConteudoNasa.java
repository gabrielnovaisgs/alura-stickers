package com.stickers.extratores_conteudo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.stickers.Entities.Conteudo;

public class ExtratorConteudoNasa implements ExtratorConteudo {
    public List<Conteudo> extariConteudos(String json) {
        // extrair somente os dados que interessam (titulo, poster, classificação)

        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de conteudos
        try {
            Object obj = new JSONParser().parse(json);

            JSONArray jObject = (JSONArray) obj;
            Iterator<JSONObject> iterator = jObject.iterator();
            while (iterator.hasNext()) {

                JSONObject obj2 = (JSONObject) iterator.next();
                String titulo = ((String) obj2.get("title")).replaceAll("[://\\_$#@%]", "_");
                String urlImagem = (String) obj2.get("url");

                Conteudo novoConteudo = new Conteudo(titulo, urlImagem);
                conteudos.add(novoConteudo);
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return conteudos;
    }
}
