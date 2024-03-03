package org.stc

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource

val dataSource = buildDataSource()

private fun buildDataSource(): HikariDataSource {
    val config = HikariConfig("./src/main/resources/hikaricp.properties")
    return HikariDataSource(config)
}