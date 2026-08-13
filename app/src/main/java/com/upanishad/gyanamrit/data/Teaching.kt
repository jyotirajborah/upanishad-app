package com.upanishad.gyanamrit.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

data class Teaching(
    val name: String,
    val sanskritName: String,
    val description: String,
    val iconType: TeachingIcon
)

enum class TeachingIcon(val icon: ImageVector) {
    UNIVERSE(Icons.Default.Star),
    LIGHT(Icons.Default.Star),
    CYCLE(Icons.Default.Refresh),
    BALANCE(Icons.Default.AccountBalance),
    LIBERATION(Icons.Default.Face)
}

object TeachingRepository {
    val teachings = listOf(
        Teaching(
            name = "Brahman",
            sanskritName = "ब्रह्मन्",
            description = "The ultimate, formless, infinite reality — the source and substance of all that exists. Brahman is existence, consciousness, and bliss (Sat-Chit-Ananda).",
            iconType = TeachingIcon.UNIVERSE
        ),
        Teaching(
            name = "Atman",
            sanskritName = "आत्मन्",
            description = "The individual self or soul. The Upanishads reveal the great truth: Atman and Brahman are one — \"Ayam Atma Brahma.\"",
            iconType = TeachingIcon.LIGHT
        ),
        Teaching(
            name = "Maya",
            sanskritName = "माया",
            description = "The cosmic illusion that veils ultimate reality. Maya makes the one appear as many, causing us to perceive the world as separate from Brahman.",
            iconType = TeachingIcon.CYCLE
        ),
        Teaching(
            name = "Karma",
            sanskritName = "कर्म",
            description = "The law of cause and effect. Every action, thought, and intention creates impressions (samskaras) that shape our future experiences.",
            iconType = TeachingIcon.BALANCE
        ),
        Teaching(
            name = "Moksha",
            sanskritName = "मोक्ष",
            description = "Liberation — the ultimate goal of human life. Freedom from the cycle of birth and death through the realization of one's true nature as Brahman.",
            iconType = TeachingIcon.LIBERATION
        )
    )
}
