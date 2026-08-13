package com.upanishad.gyanamrit.data

data class Quote(
    val text: String,
    val source: String
)

object QuoteRepository {
    val quotes = listOf(
        Quote(
            text = "Tat Tvam Asi — Thou Art That. The essence of the individual self is identical with the essence of the universe.",
            source = "Chandogya Upanishad"
        ),
        Quote(
            text = "Aham Brahmasmi — I am Brahman. The individual self, in its purest form, is none other than the universal consciousness.",
            source = "Brihadaranyaka Upanishad"
        ),
        Quote(
            text = "As a caterpillar, having reached the end of a blade of grass, draws itself together and reaches out for the next, so the Self, having let go of this body, draws itself together and reaches out for the next.",
            source = "Brihadaranyaka Upanishad (4.4.3)"
        ),
        Quote(
            text = "The Self is not born, nor does it die. It did not come into being, nor will it ever come into being. Unborn, eternal, permanent, and primeval, it is not slain when the body is slain.",
            source = "Katha Upanishad (1.2.18)"
        ),
        Quote(
            text = "From joy all beings are born, by joy they are sustained, and into joy they return.",
            source = "Taittiriya Upanishad (3.6)"
        ),
        Quote(
            text = "As rivers, flowing into the ocean, lose their names and forms, so a wise person, freed from name and form, attains the Supreme Being.",
            source = "Mundaka Upanishad (3.2.8)"
        )
    )
}
