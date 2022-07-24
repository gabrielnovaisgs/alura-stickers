package com.stickers.extratores_conteudo;

import java.util.List;

import com.stickers.Entities.Conteudo;

public interface ExtratorConteudo {
    public List<Conteudo> extariConteudos(String json);
}
