package com.example.daggerhilt_playground.util

interface EntityMapper<EntityModel, DomainModel> {

    fun EntityModel.mapToDomain(): DomainModel

    fun DomainModel.mapToEntity(): EntityModel

}