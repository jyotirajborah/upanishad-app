package com.upanishad.gyanamrit.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

data class Upanishad(
    val name: String,
    val sanskritName: String,
    val description: String,
    val veda: String,
    val iconType: UpanishadIcon
)

enum class UpanishadIcon(val icon: ImageVector) {
    OM(Icons.Default.Star),
    LIGHT(Icons.Default.Star),
    FIRE(Icons.Default.Warning),
    QUESTION(Icons.Default.Info),
    ARROW(Icons.Default.Send),
    MEDITATION(Icons.Default.Face),
    SCROLL(Icons.Default.MenuBook),
    MUSIC(Icons.Default.Favorite),
    TREE(Icons.Default.AccountTree),
    SUNRISE(Icons.Default.Place),
    SWAN(Icons.Default.Star),
    STAR(Icons.Default.Star)
}

object UpanishadRepository {
    val upanishads = listOf(
        Upanishad(
            name = "Isha Upanishad",
            sanskritName = "ईशोपनिषद्",
            description = "The shortest yet most powerful Upanishad. It teaches that the Divine pervades all of creation and advocates a life of action combined with spiritual awareness.",
            veda = "Shukla Yajurveda",
            iconType = UpanishadIcon.OM
        ),
        Upanishad(
            name = "Kena Upanishad",
            sanskritName = "केनोपनिषद्",
            description = "Asks the fundamental question: \"By whom directed does the mind go towards its objects?\" It reveals the power behind all powers — Brahman.",
            veda = "Samaveda",
            iconType = UpanishadIcon.LIGHT
        ),
        Upanishad(
            name = "Katha Upanishad",
            sanskritName = "कठोपनिषद्",
            description = "The story of young Nachiketa's dialogue with Yama (Death). It teaches the distinction between the pleasant (preya) and the good (shreya).",
            veda = "Krishna Yajurveda",
            iconType = UpanishadIcon.FIRE
        ),
        Upanishad(
            name = "Prashna Upanishad",
            sanskritName = "प्रश्नोपनिषद्",
            description = "Six sages approach the great rishi Pippalada with six profound questions about the nature of creation, prana, and the supreme reality.",
            veda = "Atharvaveda",
            iconType = UpanishadIcon.QUESTION
        ),
        Upanishad(
            name = "Mundaka Upanishad",
            sanskritName = "मुण्डकोपनिषद्",
            description = "Distinguishes between higher (para) and lower (apara) knowledge. Contains the famous metaphor of two birds on a tree — the soul and the Supreme.",
            veda = "Atharvaveda",
            iconType = UpanishadIcon.ARROW
        ),
        Upanishad(
            name = "Mandukya Upanishad",
            sanskritName = "माण्डूक्योपनिषद्",
            description = "The shortest principal Upanishad (12 verses) yet called \"sufficient for liberation.\" It analyzes the sacred syllable AUM and the four states of consciousness.",
            veda = "Atharvaveda",
            iconType = UpanishadIcon.MEDITATION
        ),
        Upanishad(
            name = "Taittiriya Upanishad",
            sanskritName = "तैत्तिरीयोपनिषद्",
            description = "Teaches the five sheaths (Pancha Kosha) of the self — from the physical body to the bliss body. Contains the famous \"Ananda Valli\" on bliss.",
            veda = "Krishna Yajurveda",
            iconType = UpanishadIcon.SCROLL
        ),
        Upanishad(
            name = "Chandogya Upanishad",
            sanskritName = "छान्दोग्योपनिषद्",
            description = "One of the oldest and largest Upanishads. Contains the great teaching \"Tat Tvam Asi\" (Thou Art That) — one of the Mahavakyas.",
            veda = "Samaveda",
            iconType = UpanishadIcon.MUSIC
        ),
        Upanishad(
            name = "Brihadaranyaka Upanishad",
            sanskritName = "बृहदारण्यकोपनिषद्",
            description = "The largest Upanishad, containing the dialogue between sage Yajnavalkya and his wife Maitreyi on the nature of the Self and immortality.",
            veda = "Shukla Yajurveda",
            iconType = UpanishadIcon.TREE
        ),
        Upanishad(
            name = "Aitareya Upanishad",
            sanskritName = "ऐतरेयोपनिषद्",
            description = "Deals with the process of creation and the Mahavakya \"Prajnanam Brahma\" — Consciousness is Brahman. Explores how the Self entered the body.",
            veda = "Rigveda",
            iconType = UpanishadIcon.SUNRISE
        ),
        Upanishad(
            name = "Shvetashvatara Upanishad",
            sanskritName = "श्वेताश्वतरोपनिषद्",
            description = "Uniquely combines personal theism with Advaita philosophy. Describes God as the cosmic magician and introduces early concepts of yoga and devotion.",
            veda = "Krishna Yajurveda",
            iconType = UpanishadIcon.SWAN
        ),
        Upanishad(
            name = "Kaushitaki Upanishad",
            sanskritName = "कौषीतकिब्राह्मणोपनिषद्",
            description = "Explores the journey of the soul after death, the nature of Brahman as pure consciousness, and the path of the gods (Devayana).",
            veda = "Rigveda",
            iconType = UpanishadIcon.STAR
        )
    )
}
