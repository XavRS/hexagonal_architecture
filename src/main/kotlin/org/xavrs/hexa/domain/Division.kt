package org.xavrs.hexa.domain

class Division private constructor(
    val code: Code,
    val description: Description
) : DomainModel {
    data class Builder(
        val code: String,
        val description: String
    ) {
        fun build() = Division(
            code = this.code,
            description = Description(this.description)
        )
    }
}

typealias Code = String

@JvmInline
value class Description(private val description: String) {
    override fun toString(): String {
        return description.replaceFirstChar { it.uppercase() }
    }
}
