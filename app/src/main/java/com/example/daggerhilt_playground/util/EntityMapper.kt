package com.example.daggerhilt_playground.util

interface EntityMapper<EntityModel, DomainModel> {

    fun EntityModel.mapToDomain(): DomainModel

    fun DomainModel.mapToEntity(): EntityModel


    fun List<EntityModel>.mapToDomainList(): List<DomainModel>

    fun List<DomainModel>.mapToEntityList(): List<EntityModel>
}