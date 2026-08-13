package com.upanishad.gyanamrit.data

data class Shloka(
    val sanskrit: String,
    val transliteration: String,
    val meaning: String,
    val source: String
)

object ShlokaRepository {
    val shlokas = listOf(
        Shloka(
            sanskrit = "ॐ पूर्णमदः पूर्णमिदं पूर्णात्पूर्णमुदच्यते ।\nपूर्णस्य पूर्णमादाय पूर्णमेवावशिष्यते ॥",
            transliteration = "Om Purnamadah Purnamidam Purnat Purnamudachyate\nPurnasya Purnamadaya Purnamevavashishyate",
            meaning = "That (Brahman) is infinite, this (universe) is infinite. The infinite proceeds from the infinite. Taking the infinity of the infinite, it remains as the infinite alone.",
            source = "Isha Upanishad — Shanti Mantra"
        ),
        Shloka(
            sanskrit = "असतो मा सद्गमय ।\nतमसो मा ज्योतिर्गमय ।\nमृत्योर्मा अमृतं गमय ॥",
            transliteration = "Asato Ma Sad Gamaya\nTamaso Ma Jyotir Gamaya\nMrityor Ma Amritam Gamaya",
            meaning = "Lead me from the unreal to the real. Lead me from darkness to light. Lead me from death to immortality.",
            source = "Brihadaranyaka Upanishad (1.3.28)"
        ),
        Shloka(
            sanskrit = "ईशा वास्यमिदं सर्वं यत्किञ्च जगत्यां जगत् ।\nतेन त्यक्तेन भुञ्जीथा मा गृधः कस्यस्विद्धनम् ॥",
            transliteration = "Isha Vasyamidam Sarvam Yat Kincha Jagatyam Jagat\nTena Tyaktena Bhunjitha Ma Gridhah Kasyasvid Dhanam",
            meaning = "All this — whatever exists in this changing universe — is pervaded by God. Protect yourself through detachment. Do not covet the wealth of anyone.",
            source = "Isha Upanishad (Verse 1)"
        ),
        Shloka(
            sanskrit = "अयमात्मा ब्रह्म ।",
            transliteration = "Ayam Atma Brahma",
            meaning = "This Self (Atman) is Brahman. The individual self is identical with the ultimate reality — one of the four Mahavakyas (great sayings) of the Upanishads.",
            source = "Mandukya Upanishad — Mahavakya"
        ),
        Shloka(
            sanskrit = "सर्वं खल्विदं ब्रह्म ।\nतज्जलानिति शान्त उपासीत ॥",
            transliteration = "Sarvam Khalvidam Brahma\nTajjalaniti Shanta Upasita",
            meaning = "All this is indeed Brahman. Everything arises from, is sustained by, and dissolves back into Brahman. One should meditate on this peacefully.",
            source = "Chandogya Upanishad (3.14.1)"
        ),
        Shloka(
            sanskrit = "यथा नद्यः स्यन्दमानाः समुद्रे\nअस्तं गच्छन्ति नामरूपे विहाय ।\nतथा विद्वान्नामरूपाद्विमुक्तः\nपरात्परं पुरुषमुपैति दिव्यम् ॥",
            transliteration = "Yatha Nadyah Syandamanah Samudre\nAstam Gacchanti Namarupe Vihaya\nTatha Vidvan Namarupad Vimuktah\nParatparam Purusham Upaiti Divyam",
            meaning = "As flowing rivers dissolve into the ocean, losing their names and forms, so the wise, freed from name and form, attain the Supreme Divine Being.",
            source = "Mundaka Upanishad (3.2.8)"
        ),
        Shloka(
            sanskrit = "आनन्दाद्ध्येव खल्विमानि भूतानि जायन्ते ।\nआनन्देन जातानि जीवन्ति ।\nआनन्दं प्रयन्त्यभिसंविशन्ति ॥",
            transliteration = "Anandaddhy Eva Khalvimani Bhutani Jayante\nAnandena Jatani Jivanti\nAnandam Prayanty Abhisamvishanti",
            meaning = "From bliss, indeed, all these beings are born. By bliss they are sustained after being born. Into bliss they enter and merge upon departing.",
            source = "Taittiriya Upanishad (3.6)"
        )
    )
    
    fun getDailyShloka(): Shloka {
        val dayOfYear = java.time.LocalDate.now().dayOfYear
        return shlokas[dayOfYear % shlokas.size]
    }
}
