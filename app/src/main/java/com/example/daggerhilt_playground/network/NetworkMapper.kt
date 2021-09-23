package com.example.daggerhilt_playground.network

import com.example.daggerhilt_playground.models.Blog
import com.example.daggerhilt_playground.util.EntityMapper

object NetworkMapper : EntityMapper<BlogNetworkEntity, Blog> {

    override fun BlogNetworkEntity.mapToDomain(): Blog = Blog(
        id = this.pk,
        title = this.title,
        body = this.body,
        image = this.image,
        category = this.category
    )

    override fun Blog.mapToEntity(): BlogNetworkEntity = BlogNetworkEntity(
        pk = this.id,
        title = this.title,
        body = this.body,
        image = this.image,
        category = this.category
    )

    fun List<BlogNetworkEntity>.mapToDomainList(): List<Blog> = this.map { it.mapToDomain() }

    fun List<Blog>.mapToEntityList(): List<BlogNetworkEntity> = this.map { it.mapToEntity() }
}