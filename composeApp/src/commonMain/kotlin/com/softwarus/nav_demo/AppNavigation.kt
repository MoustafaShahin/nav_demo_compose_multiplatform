package com.softwarus.nav_demo

import androidx.compose.ui.text.input.KeyboardType.Companion.Uri
import androidx.core.bundle.Bundle
import androidx.navigation.NavType
import com.eygraber.uri.UriCodec
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
object First

@Serializable
data class Second(val objValue:CustomClass)

object CustomNavTypes{

    val customClassType  = object : NavType<CustomClass>(false) {
        override fun get(bundle: Bundle, key: String): CustomClass? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): CustomClass {
            return Json.decodeFromString(UriCodec.decode(value))
        }

        override fun serializeAsValue(value: CustomClass): String {
            return UriCodec.encode(Json.encodeToString(value))
        }

        override fun put(bundle: Bundle, key: String, value: CustomClass) {
            bundle.putString(key, Json.encodeToString(value))
        }
    }

}