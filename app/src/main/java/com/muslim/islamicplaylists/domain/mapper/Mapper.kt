package com.muslim.islamicplaylists.domain.mapper

interface Mapper<I,O> {
    fun map(input:I):O
}