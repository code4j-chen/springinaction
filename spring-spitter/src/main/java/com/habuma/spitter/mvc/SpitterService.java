package com.habuma.spitter.mvc;

import java.util.List;

/**
 * Created by code4j on 2014/12/12.
 */
public interface SpitterService {
    List<Spittle> getRecentSpittles(int page);
}
