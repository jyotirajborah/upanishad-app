package com.upanishad.gyanamrit.data

data class Teaching(
    val name: String,
    val sanskritName: String,
    val description: String,
    val icon: String
)

object TeachingRepository {
    val teachings = listOf(
        Teaching(
            name = "Brahman",
            sanskritName = "ब्रह्मन्",
            description = "The ultimate, formless, infinite reality — the source and substance of all that exists. Brahman is existence, consciousness, and bliss (Sat-Chit-Ananda).",
            icon = "🌌"
        ),
        Teaching(
            name = "Atman",
            sanskritName = "आत्मन्",
            description = "The individual self or soul. The Upanishads reveal the great truth: Atman and Brahman are one — \"Ayam Atma Brahma.\"",
            icon = "✨"
        ),
        Teaching(
            name = "Maya",
            sanskritName = "माया",
            description = "The cosmic illusion that veils ultimate reality. Maya makes the one appear as many, causing us to perceive the world as separate from Brahman.",
            icon = "🌀"
        ),
        Teaching(
            name = "Karma",
            sanskritName = "कर्म",
            description = "The law of cause and effect. Every action, thought, and intention creates impressions (samskaras) that shape our future experiences.",
            icon = "⚖️"
        ),
        Teaching(
            name = "Moksha",
            sanskritName = "मोक्ष",
            description = "Liberation — the ultimate goal of human life. Freedom from the cycle of birth and death through the realization of one's true nature as Brahman.",
            icon = "🕊️"
        )
    )
}
