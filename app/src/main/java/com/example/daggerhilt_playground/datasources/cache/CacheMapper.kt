package com.example.daggerhilt_playground.datasources.cache

import com.example.daggerhilt_playground.domain.models.Blog
import com.example.daggerhilt_playground.util.EntityMapper

object CacheMapper : EntityMapper<BlogCacheEntity, Blog> {

    override fun BlogCacheEntity.mapToDomain(): Blog = Blog(
        id = this.id,
        title = this.title,
        body = this.body,
        image = this.image,
        category = this.category
    )

    override fun Blog.mapToEntity(): BlogCacheEntity = BlogCacheEntity(
        id = this.id,
        title = this.title,
        body = this.body,
        image = this.image,
        category = this.category
    )

    override fun List<BlogCacheEntity>.mapToDomainList(): List<Blog> =
        this.map {
            it.mapToDomain()
        }

    override fun List<Blog>.mapToEntityList(): List<BlogCacheEntity> =
        this.map {
            it.mapToEntity()
        }
}