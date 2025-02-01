package com.softwarus.nav_demo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform