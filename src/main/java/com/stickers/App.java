package com.stickers;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import com.stickers.Entities.Conteudo;
import com.stickers.extratores_conteudo.ExtratorConteudo;
import com.stickers.extratores_conteudo.ExtratorConteudoNasa;

public class App {
    public static void main(String[] args) throws Exception {

        // String url = "https://alura-imdb-api.herokuapp.com/movies";
        // ExtratorConteudo extrator = new ExtratorConteudoImdb();

        String url = "https://api.nasa.gov/planetary/apod?api_key=udkAb5wa361U0CKQ8jJa1F8BQeXqSVlWeu9EQNxU&start_date=2022-07-20";

        // String url = "https://alura-imersao-java.herokuapp.com/linguagens";
        ExtratorConteudo extrator = new ExtratorConteudoNasa();

        // String url = "http://localhost:8080/linguagens";
        ClienteHttp http = new ClienteHttp();
        String json = http.buscaDados(url);

        List<Conteudo> conteudos = extrator.extariConteudos(json);

        // exibir e manipular os dados

        GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();
        int count = 0;
        for (Conteudo conteudo : conteudos) {
            if (count < 3) {

                String nomeArquivo = conteudo.getTitulo() + ".png";
                InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();

                geradora.criar(inputStream, nomeArquivo);
                System.out.println(conteudo.getTitulo());
                System.out.println();
            }
            count++;

        }
    }
}
