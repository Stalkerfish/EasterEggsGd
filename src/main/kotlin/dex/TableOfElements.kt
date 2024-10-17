package dex

object TableOfElements {
    fun getElement(): ArrayList<Element>{
        val elementsList = ArrayList<Element>()

        val hydrogen = Element(
            id = 0,
            name = "Hydrogen",
            symbol = "H",
            family = "Non-Metal",
            atomicNumber = 1,
            atomicWeight = 1.0078,
            description = "The most abundant element in the universe. It's what stars are mostly made of!"
        )
        elementsList.add(hydrogen)

        val helium = Element(
            id = 1,
            name = "Helium",
            symbol = "He",
            family = "Noble Gas",
            atomicNumber = 2,
            atomicWeight = 4.0026,
            description =  "This element fills balloons and gives them the ability to float. It's also a noble gas."
        )
        elementsList.add(helium)

        val lithium = Element(
            id = 2,
            name = "Lithium",
            symbol = "Li",
            family = "Alkaline Metals",
            atomicNumber = 3,
            atomicWeight = 6.9410,
            description = "A lightweight metal that's crucial for rechargeable batteries. It's used in phones and electric cars."
        )
        elementsList.add(lithium)

        val beryllium = Element(
            id = 3,
            name = "Beryllium",
            symbol = "Be",
            family = "Alkaline Earth Metals",
            atomicNumber = 4,
            atomicWeight = 9.0122,
            description = "This element is strong yet light, often found in spacecraft materials and gemstones like emeralds."
        )
        elementsList.add(beryllium)

        val boron = Element(
            id = 4,
            name = "Boron",
            symbol = "B",
            family = "Semimetal",
            atomicNumber = 5,
            atomicWeight = 10.811,
            description = "You might find this in your laundry detergent, but it also strengthens glass and ceramics."
        )
        elementsList.add(boron)

        val carbon = Element(
            id = 5,
            name = "Carbon",
            symbol = "C",
            family = "Non-Metal",
            atomicNumber = 6,
            atomicWeight = 12.011,
            description = "It's the building block of life, forming the backbone of DNA, proteins, and most organic compounds."
        )
        elementsList.add(carbon)

        val nitrogen = Element(
            id = 6,
            name = "Nitrogen",
            symbol = "N",
            family = "Non-Metal",
            atomicNumber = 7,
            atomicWeight = 14.007,
            description = "This gas makes up 78% of Earth's atmosphere. Essential for plant growth, but tricky to use!"
        )
        elementsList.add(nitrogen)

        val oxygen = Element(
            id = 7,
            name = "Oxygen",
            symbol = "O",
            family = "Non-Metal",
            atomicNumber = 8,
            atomicWeight = 15.999,
            description = "The element that keeps us alive! You breathe it in every second."
        )
        elementsList.add(oxygen)

        val fluorine = Element(
            id = 8,
            name = "Fluorine",
            symbol = "F",
            family = "Non-Metal",
            atomicNumber = 9,
            atomicWeight = 18.998,
            description = "Found in your toothpaste, it helps keep your teeth strong and cavity-free."
        )
        elementsList.add(fluorine)

        val neon = Element(
            id = 9,
            name = "Neon",
            symbol = "Ne",
            family = "Noble Gas",
            atomicNumber = 10,
            atomicWeight = 20.180,
            description = "This element lights up the night in vibrant, colorful signs. A noble gas with a glow!"
        )
        elementsList.add(neon)

        val sodium = Element(
            id = 10,
            name = "Sodium",
            symbol = "Na",
            family = "Alkaline Metal",
            atomicNumber = 11,
            atomicWeight = 22.990,
            description = "This soft metal reacts vigorously with water and is a crucial part of table salt."
        )
        elementsList.add(sodium)

        val magnesium = Element(
            id = 11,
            name = "Magnesium",
            symbol = "Mg",
            family = "Alkaline Earth Metals",
            atomicNumber = 12,
            atomicWeight = 24.305,
            description =  "A lightweight metal that burns bright white. It's also essential for strong bones."
        )
        elementsList.add(magnesium)

        val aluminium = Element(
            id = 12,
            name = "Aluminium",
            symbol = "Al",
            family = "Post-Transition Metal",
            atomicNumber = 13,
            atomicWeight = 26.982,
            description = "This metal is lightweight, non-corrosive, and often found in soda cans and airplanes."
        )
        elementsList.add(aluminium)

        val silicon = Element(
            id = 13,
            name = "Silicon",
            symbol = "Si",
            family = "Semimetal",
            atomicNumber = 14,
            atomicWeight = 28.086,
            description = "The cornerstone of modern technology, found in computer chips and sand."
        )
        elementsList.add(silicon)

        val phosphorus = Element(
            id = 14,
            name = "Phosphorus",
            symbol = "P",
            family = "Non-Metal",
            atomicNumber = 15,
            atomicWeight = 30.974,
            description = "Glows in the dark and is essential for DNA and ATP – the energy currency of life."
        )
        elementsList.add(phosphorus)

        val sulfur = Element(
            id = 15,
            name = "Sulfur",
            symbol = "S",
            family = "Non-Metal",
            atomicNumber = 16,
            atomicWeight = 32.065,
            description = "This element smells like rotten eggs, but it's crucial for matches and gunpowder."
        )
        elementsList.add(sulfur)

        val chlorine = Element(
            id = 16,
            name = "Chlorine",
            symbol = "Cl",
            family = "Non-Metal",
            atomicNumber = 17,
            atomicWeight = 35.453,
            description =  "A greenish gas used to keep swimming pools clean, but be careful – it's highly reactive!"
        )
        elementsList.add(chlorine)

        val argon = Element(
            id = 17,
            name = "Argon",
            symbol = "Ar",
            family = "Noble Gas",
            atomicNumber = 18,
            atomicWeight = 39.948,
            description = "A noble gas that doesn't react much, but it's used in welding and in lightbulbs to protect the filament."
        )
        elementsList.add(argon)

        val potassium = Element(
            id = 18,
            name = "Potassium",
            symbol = "K",
            family = "Alkaline Metal",
            atomicNumber = 19,
            atomicWeight = 39.098,
            description = "A soft metal that reacts explosively with water, essential for nerve function in your body."
        )
        elementsList.add(potassium)

        val calcium = Element(
            id = 19,
            name = "Calcium",
            symbol = "Ca",
            family = "Alkaline Earth Metal",
            atomicNumber = 20,
            atomicWeight = 40.078,
            description = "Found in your bones and teeth, and it's what makes cement harden."
        )
        elementsList.add(calcium)

        val scandium = Element(
            id = 20,
            name = "Scandium",
            symbol = "Sc",
            family = "Transition Metal",
            atomicNumber = 21,
            atomicWeight = 44.956,
            description = "A rare, lightweight metal used in aerospace components and sporting goods."
        )
        elementsList.add(scandium)

        val titanium = Element(
            id = 21,
            name = "Titanium",
            symbol = "Ti",
            family = "Transition Metal",
            atomicNumber = 22,
            atomicWeight = 47.867,
            description = "Strong as steel, but lighter. You'll find it in aerospace materials and high-end bicycles."
        )
        elementsList.add(titanium)

        val vanadium = Element(
            id = 22,
            name = "Vanadium",
            symbol = "V",
            family = "Transition Metal",
            atomicNumber = 23,
            atomicWeight = 50.942,
            description =  "Known for its ability to strengthen steel, it's used in car springs and gears."
        )
        elementsList.add(vanadium)

        val chromium = Element(
            id = 23,
            name = "Chromium",
            symbol = "Cr",
            family = "Transition Metal",
            atomicNumber = 24,
            atomicWeight = 51.996,
            description = "This shiny metal gives stainless steel its shine and is also used in car bumpers."
        )
        elementsList.add(chromium)

        val manganese = Element(
            id = 24,
            name = "Manganese",
            symbol = "Mn",
            family = "Transition Metal",
            atomicNumber = 25,
            atomicWeight = 54.938,
            description =  "An essential component in steelmaking, giving it toughness and wear resistance."
        )
        elementsList.add(manganese)

        val iron = Element(
            id = 25,
            name = "Iron",
            symbol = "Fe",
            family = "Transition Metal",
            atomicNumber = 26,
            atomicWeight = 55.845,
            description =  "A metal that's been used for thousands of years, from swords to skyscrapers."
        )
        elementsList.add(iron)

        val cobalt = Element(
            id = 26,
            name = "Cobalt",
            symbol = "Co",
            family = "Transition Metal",
            atomicNumber = 27,
            atomicWeight = 58.933,
            description = "Found in the blue pigments of ancient artwork and now in rechargeable batteries."
        )
        elementsList.add(cobalt)

        val nickel = Element(
            id = 27,
            name = "Nickel",
            symbol = "Ni",
            family = "Transition Metal",
            atomicNumber = 28,
            atomicWeight = 58.693,
            description = "A shiny metal used in coins and stainless steel, also found in rechargeable batteries."
        )
        elementsList.add(nickel)

        val copper = Element(
            id = 28,
            name = "Copper",
            symbol = "Cu",
            family = "Transition Metal",
            atomicNumber = 29,
            atomicWeight = 63.546,
            description = "Used for electrical wiring due to its excellent conductivity, and you’ll see it turn green with age."
        )
        elementsList.add(copper)

        val zinc = Element(
            id = 29,
            name = "Zinc",
            symbol = "Zn",
            family = "Transition Metal",
            atomicNumber = 30,
            atomicWeight = 65.380,
            description = "Coats steel to prevent rust, and is also an essential nutrient for your immune system."
        )
        elementsList.add(zinc)

        val gallium = Element(
            id = 30,
            name = "Gallium",
            symbol = "Ga",
            family = "Post-Transition Metal",
            atomicNumber = 31,
            atomicWeight = 69.723,
            description = "This metal melts in your hand and is used in semiconductors and LED lights."
        )
        elementsList.add(gallium)

        val germanium = Element(
            id = 31,
            name = "Germanium",
            symbol = "Ge",
            family = "Semimetal",
            atomicNumber = 32,
            atomicWeight = 72.640,
            description =  "Used in fiber optics and infrared optics. Similar to silicon in semiconductor applications."
        )
        elementsList.add(germanium)

        val arsenic = Element(
            id = 32,
            name = "Arsenic",
            symbol = "As",
            family = "Semimetal",
            atomicNumber = 33,
            atomicWeight = 74.922,
            description =  "Notorious for its toxicity, but also used in semiconductors and to treat certain diseases."
        )
        elementsList.add(arsenic)

        val selenium = Element(
            id = 33,
            name = "Selenium",
            symbol = "Se",
            family = "Non-Metal",
            atomicNumber = 34,
            atomicWeight = 78.960,
            description = "Used in photocopiers and solar cells, it conducts electricity when exposed to light."
        )
        elementsList.add(selenium)

        val bromine = Element(
            id = 34,
            name = "Bromine",
            symbol = "Br",
            family = "Non-Metal",
            atomicNumber = 35,
            atomicWeight = 79.904,
            description = "A red-brown liquid at dex.getRoom temperature, used in flame retardants and some medicines."
        )
        elementsList.add(bromine)

        val krypton = Element(
            id = 35,
            name = "Krypton",
            symbol = "Kr",
            family = "Noble Gas",
            atomicNumber = 36,
            atomicWeight = 83.798,
            description = "A noble gas found in high-performance lighting and photographic flashes."
        )
        elementsList.add(krypton)

        val rubidium = Element(
            id = 36,
            name = "Rubidium",
            symbol = "Rb",
            family = "Alkaline Metal",
            atomicNumber = 37,
            atomicWeight = 85.468,
            description = "Highly reactive, used in atomic clocks and sometimes in fireworks for a purple color."
        )
        elementsList.add(rubidium)

        val strontium = Element(
            id = 37,
            name = "Strontium",
            symbol = "Sr",
            family = "Alkaline Earth Metal",
            atomicNumber = 38,
            atomicWeight = 87.620,
            description = "Famous for its red flames in fireworks and its role in strengthening bones."
        )
        elementsList.add(strontium)

        val yttrium = Element(
            id = 38,
            name = "Yttrium",
            symbol = "Y",
            family = "Transition Metal",
            atomicNumber = 39,
            atomicWeight = 88.906,
            description = "Found in LED screens and superconductors, it helps create the color red in TV displays."
        )
        elementsList.add(yttrium)

        val zirconium = Element(
            id = 39,
            name = "Zirconium",
            symbol = "Zr",
            family = "Transition Metal",
            atomicNumber = 40,
            atomicWeight = 91.224,
            description =  "Used in nuclear reactors due to its ability to withstand corrosion. Also found in gemstones."
        )
        elementsList.add(zirconium)

        val niobium = Element(
            id = 40,
            name = "Niobium",
            symbol = "Nb",
            family = "Transition Metal",
            atomicNumber = 41,
            atomicWeight = 92.906,
            description = "A shiny metal that’s highly resistant to corrosion, used in jet engines and superconductors."
        )
        elementsList.add(niobium)

        val molybdenum = Element(
            id = 41,
            name = "Molybdenum",
            symbol = "Mo",
            family = "Transition Metal",
            atomicNumber = 42,
            atomicWeight = 95.950,
            description = "Found in steel alloys for strength and heat resistance, it's essential in enzymes too."
        )
        elementsList.add(molybdenum)

        val technetium = Element(
            id = 42,
            name = "Technetium",
            symbol = "Tc",
            family = "Transition Metal",
            atomicNumber = 43,
            atomicWeight = 98.0,
            description = "A radioactive element that doesn’t occur naturally, but is used in medical imaging."
        )
        elementsList.add(technetium)

        val ruthenium = Element(
            id = 43,
            name = "Ruthenium",
            symbol = "Ru",
            family = "Transition Metal",
            atomicNumber = 44,
            atomicWeight = 101.07,
            description = "A rare, hard metal used in electronics and as a catalyst in chemical reactions."
        )
        elementsList.add(ruthenium)

        val rhodium = Element(
            id = 44,
            name = "Rhodium",
            symbol = "Rh",
            family = "Transition Metal",
            atomicNumber = 45,
            atomicWeight = 102.91,
            description = "The most reflective metal, used in mirrors and as a catalyst in car exhaust systems."
        )
        elementsList.add(rhodium)

        val palladium = Element(
            id = 45,
            name = "Palladium",
            symbol = "Pd",
            family = "Transition Metal",
            atomicNumber = 46,
            atomicWeight = 106.42,
            description = "A key component in catalytic converters and jewelry, prized for its rarity and durability."
        )
        elementsList.add(palladium)

        val silver = Element(
            id = 46,
            name = "Silver",
            symbol = "Ag",
            family = "Transition Metal",
            atomicNumber = 47,
            atomicWeight = 107.87,
            description =  "Valued for its beauty and conductivity, it's used in jewelry, electronics, and photography."
        )
        elementsList.add(silver)

        val cadmium = Element(
            id = 47,
            name = "Cadmium",
            symbol = "Cd",
            family = "Transition Metal",
            atomicNumber = 48,
            atomicWeight = 112.41,
            description = "Used in batteries and pigments, but toxic in large quantities."
        )
        elementsList.add(cadmium)

        val indium = Element(
            id = 48,
            name = "Indium",
            symbol = "In",
            family = "Post-Transition Metal",
            atomicNumber = 49,
            atomicWeight = 114.82,
            description =  "This soft metal is used in touchscreens and solar panels due to its conductive properties."
        )
        elementsList.add(indium)

        val tin = Element(
            id = 49,
            name = "Tin",
            symbol = "Sn",
            family = "Post-Transition Metal",
            atomicNumber = 50,
            atomicWeight = 118.71,
            description = "Used in solder to join metals, and in ancient times, it was alloyed with copper to make bronze."
        )
        elementsList.add(tin)

        val antimony = Element(
            id = 50,
            name = "Antimony",
            symbol = "Sb",
            family = "Semimetal",
            atomicNumber = 51,
            atomicWeight = 121.76,
            description = "A shiny metalloid known since ancient times, used in flame retardants and semiconductors."
        )
        elementsList.add(antimony)

        val tellurium = Element(
            id = 51,
            name = "Tellurium",
            symbol = "Te",
            family = "Semimetal",
            atomicNumber = 52,
            atomicWeight = 127.60,
            description = "Often found in solar panels, this rare metalloid helps improve conductivity."
        )
        elementsList.add(tellurium)

        val iodine = Element(
            id = 52,
            name = "Iodine",
            symbol = "I",
            family = "Non-Metal",
            atomicNumber = 53,
            atomicWeight = 126.90,
            description = "A violet-colored solid that’s essential for thyroid health, often found in iodized salt."
        )
        elementsList.add(iodine)

        val xenon = Element(
            id = 53,
            name = "Xenon",
            symbol = "Xe",
            family = "Noble Gas",
            atomicNumber = 54,
            atomicWeight = 131.29,
            description = "A noble gas used in high-intensity lamps, flashlights, and even as an anesthetic."
        )
        elementsList.add(xenon)

        val caesium = Element(
            id = 54,
            name = "Caesium",
            symbol = "Cs",
            family = "Alkaline Metal",
            atomicNumber = 55,
            atomicWeight = 132.91,
            description = "One of the most reactive elements, it’s used in atomic clocks for ultra-precise timekeeping."
        )
        elementsList.add(caesium)

        val barium = Element(
            id = 55,
            name = "Barium",
            symbol = "Ba",
            family = "Alkaline Earth Metal",
            atomicNumber = 56,
            atomicWeight = 137.33,
            description = "Used in medical imaging to help highlight the digestive system, and also in fireworks for green color."
        )
        elementsList.add(barium)

        val lanthanum = Element(
            id = 56,
            name = "Lanthanum",
            symbol = "La",
            family = "Lanthanide",
            atomicNumber = 57,
            atomicWeight = 138.91,
            description = "A rare earth metal used in hybrid car batteries and camera lenses."
        )
        elementsList.add(lanthanum)

        val cerium = Element(
            id = 57,
            name = "Cerium",
            symbol = "Ce",
            family = "Lanthanide",
            atomicNumber = 58,
            atomicWeight = 140.12,
            description =  "Found in lighter flints, this element is used in glass polishing and as a catalyst in cars."
        )
        elementsList.add(cerium)

        val praseodymium = Element(
            id = 58,
            name = "Praseodymium",
            symbol = "Pr",
            family = "Lanthanide",
            atomicNumber = 59,
            atomicWeight = 140.91,
            description = "A rare earth metal used in magnets, and it gives glass a yellow tint."
        )
        elementsList.add(praseodymium)

        val neodymium = Element(
            id = 59,
            name = "Neodymium",
            symbol = "Nd",
            family = "Lanthanide",
            atomicNumber = 60,
            atomicWeight = 144.24,
            description =  "You’ve likely encountered this in powerful magnets used in speakers and motors."
        )
        elementsList.add(neodymium)

        val promethium = Element(
            id = 60,
            name = "Promethium",
            symbol = "Pm",
            family = "Lanthanide",
            atomicNumber = 61,
            atomicWeight = 145.0,
            description = "A radioactive element found in luminous paints and some batteries for pacemakers."
        )
        elementsList.add(promethium)

        val samarium = Element(
            id = 61,
            name = "Samarium",
            symbol = "Sm",
            family = "Lanthanide",
            atomicNumber = 62,
            atomicWeight = 150.36,
            description = "Used in magnets, lasers, and even in cancer treatment as a neutron absorber."
        )
        elementsList.add(samarium)

        val europium = Element(
            id = 62,
            name = "Europium",
            symbol = "Eu",
            family = "Lanthanide",
            atomicNumber = 63,
            atomicWeight = 151.96,
            description = "This element makes red and blue colors in TV screens and is used in fluorescent lighting, it is named after the continent of Europe."
        )
        elementsList.add(europium)

        val gadolinium = Element(
            id = 63,
            name = "Gadolinium",
            symbol = "Gd",
            family = "Lanthanide",
            atomicNumber = 64,
            atomicWeight = 157.25,
            description = "Essential for MRI scans, this element enhances the contrast of medical images."
        )
        elementsList.add(gadolinium)

        val terbium = Element(
            id = 64,
            name = "Terbium",
            symbol = "Tb",
            family = "Lanthanide",
            atomicNumber = 65,
            atomicWeight = 158.93,
            description = "Used in green phosphors for color TVs and LEDs. It’s also a component in some magnets."
        )
        elementsList.add(terbium)

        val dysprosium = Element(
            id = 65,
            name = "Dysprosium",
            symbol = "Dy",
            family = "Lanthanide",
            atomicNumber = 66,
            atomicWeight = 162.5,
            description = "Used in magnets that need to operate at high temperatures, like in electric car motors."
        )
        elementsList.add(dysprosium)

        val holmium = Element(
            id = 66,
            name = "Holmium",
            symbol = "Ho",
            family = "Lanthanide",
            atomicNumber = 67,
            atomicWeight = 164.93,
            description = "This element has the highest magnetic strength of any element, used in magnetic flux concentrators."
        )
        elementsList.add(holmium)

        val erbium = Element(
            id = 67,
            name = "Erbium",
            symbol = "Er",
            family = "Lanthanide",
            atomicNumber = 68,
            atomicWeight = 167.26,
            description = "Used in optical fibers for high-speed internet and in laser surgery."
        )
        elementsList.add(erbium)

        val thulium = Element(
            id = 68,
            name = "Thulium",
            symbol = "Tm",
            family = "Lanthanide",
            atomicNumber = 69,
            atomicWeight = 168.93,
            description = "A rare earth metal used in portable X-ray machines and in some laser technologies."
        )
        elementsList.add(thulium)

        val ytterbium = Element(
            id = 69,
            name = "Ytterbium",
            symbol = "Yb",
            family = "Lanthanide",
            atomicNumber = 70,
            atomicWeight = 173.04,
            description = "Used in stress gauges and certain lasers, it can also improve the strength of steel."
        )
        elementsList.add(ytterbium)

        val lutetium = Element(
            id = 70,
            name = "Lutetium",
            symbol = "Lu",
            family = "Lanthanide",
            atomicNumber = 71,
            atomicWeight = 174.97,
            description = "A rare earth metal used in PET scan detectors and some forms of cancer treatment."
        )
        elementsList.add(lutetium)

        val hafnium = Element(
            id = 71,
            name = "Hafnium",
            symbol = "Hf",
            family = "Transition Metal",
            atomicNumber = 72,
            atomicWeight = 178.49,
            description =  "Used in nuclear control rods due to its ability to absorb neutrons."
        )
        elementsList.add(hafnium)

        val tantalum = Element(
            id = 72,
            name = "Tantalum",
            symbol = "Ta",
            family = "Transition Metal",
            atomicNumber = 73,
            atomicWeight = 180.95,
            description =  "Highly resistant to corrosion, it’s used in electronics, surgical implants, and capacitors."
        )
        elementsList.add(tantalum)

        val tungsten = Element(
            id = 73,
            name = "Tungsten",
            symbol = "W",
            family = "Transition Metal",
            atomicNumber = 74,
            atomicWeight = 183.84,
            description = "Known for having the highest melting point, it’s used in light bulb filaments and cutting tools."
        )
        elementsList.add(tungsten)

        val rhenium = Element(
            id = 74,
            name = "Rhenium",
            symbol = "Re",
            family = "Transition Metal",
            atomicNumber = 75,
            atomicWeight = 186.21,
            description =  "An extremely rare metal, used in high-temperature turbine engines and jet engines."
        )
        elementsList.add(rhenium)

        val osmium = Element(
            id = 75,
            name = "Osmium",
            symbol = "Os",
            family = "Transition Metal",
            atomicNumber = 76,
            atomicWeight = 190.23,
            description = "One of the densest elements, used in fountain pen nibs and electrical contacts."
        )
        elementsList.add(osmium)

        val iridium = Element(
            id = 76,
            name = "Iridium",
            symbol = "Ir",
            family = "Transition Metal",
            atomicNumber = 77,
            atomicWeight = 192.22,
            description = "Another incredibly dense metal, it’s used in spark plugs and as a hardening agent for platinum."
        )
        elementsList.add(iridium)

        val platinum = Element(
            id = 77,
            name = "dex.getPlatinum",
            symbol = "Pt",
            family = "Transition Metal",
            atomicNumber = 78,
            atomicWeight = 195.08,
            description = "Valued for its rarity and use in jewelry, it's also a key component in catalytic converters."
        )
        elementsList.add(platinum)

        val gold = Element(
            id = 78,
            name = "Gold",
            symbol = "Au",
            family = "Transition Metal",
            atomicNumber = 79,
            atomicWeight = 196.97,
            description =  "A timeless symbol of wealth, this element doesn’t tarnish and is highly conductive, making it useful in electronics."
        )
        elementsList.add(gold)

        val mercury = Element(
            id = 79,
            name = "Mercury",
            symbol = "Hg",
            family = "Transition Metal",
            atomicNumber = 80,
            atomicWeight = 200.59,
            description =  "A liquid at dex.getRoom temperature, once used in thermometers, but now mostly phased out due to toxicity."
        )
        elementsList.add(mercury)

        val thallium = Element(
            id = 80,
            name = "Thallium",
            symbol = "Tl",
            family = "Post-Transition Metal",
            atomicNumber = 81,
            atomicWeight = 204.38,
            description = "A soft metal used in electronics and some medical imaging, but highly toxic."
        )
        elementsList.add(thallium)

        val lead = Element(
            id = 81,
            name = "Lead",
            symbol = "Pb",
            family = "Post-Transition Metal",
            atomicNumber = 82,
            atomicWeight = 207.20,
            description = "Heavy and toxic, this metal was once used in pipes and paints but now mainly in batteries."
        )
        elementsList.add(lead)

        val bismuth = Element(
            id = 82,
            name = "Bismuth",
            symbol = "Bi",
            family = "Post-Transition Metal",
            atomicNumber = 83,
            atomicWeight = 208.98,
            description = "A colorful metal used in medicines like Pepto-Bismol and cosmetics."
        )
        elementsList.add(bismuth)

        val polonium = Element(
            id = 83,
            name = "Polonium",
            symbol = "Bi",
            family = "Post-Transition Metal",
            atomicNumber = 84,
            atomicWeight = 209.0,
            description =  "A highly radioactive element, known for its role in early nuclear research and as a poison, discovered by Marie Curie."
        )
        elementsList.add(polonium)

        val astatine = Element(
            id = 84,
            name = "Astatine",
            symbol = "At",
            family = "Post-Transition Metal",
            atomicNumber = 85,
            atomicWeight = 210.0,
            description = "The rarest naturally occurring element, used in cancer treatment as a radioactive isotope."
        )
        elementsList.add(astatine)

        val radon = Element(
            id = 85,
            name = "Radon",
            symbol = "Rn",
            family = "Noble Gas",
            atomicNumber = 86,
            atomicWeight = 222.0,
            description = "A radioactive gas that can accumulate in basements, it’s a health hazard in poorly ventilated spaces."
        )
        elementsList.add(radon)

        val francium = Element(
            id = 86,
            name = "Francium",
            symbol = "Fr",
            family = "Alkaline Metal",
            atomicNumber = 87,
            atomicWeight = 223.0,
            description = "One of the rarest and most unstable elements, decaying quickly into other elements."
        )
        elementsList.add(francium)

        val radium = Element(
            id = 87,
            name = "Radium",
            symbol = "Ra",
            family = "Alkaline Earth Metal",
            atomicNumber = 88,
            atomicWeight = 226.0,
            description = "Once used in glow-in-the-dark watches, but highly radioactive and dangerous. Discovered by Marie Curie"
        )
        elementsList.add(radium)

        val actinium = Element(
            id = 88,
            name = "Actinium",
            symbol = "Ac",
            family = "Actinide",
            atomicNumber = 89,
            atomicWeight = 227.0,
            description = "A highly radioactive metal, used in cancer treatment and research."
        )
        elementsList.add(actinium)

        val thorium = Element(
            id = 89,
            name = "Thorium",
            symbol = "Th",
            family = "Actinide",
            atomicNumber = 90,
            atomicWeight = 232.04,
            description = "A potential alternative to uranium in nuclear reactors, with a longer fuel life."
        )
        elementsList.add(thorium)

        val protactinium = Element(
            id = 90,
            name = "Protactinium",
            symbol = "Pa",
            family = "Actinide",
            atomicNumber = 91,
            atomicWeight = 231.04,
            description = "A rare and highly radioactive element, used mainly for research purposes."
        )
        elementsList.add(protactinium)

        val uranium = Element(
            id = 91,
            name = "Uranium",
            symbol = "U",
            family = "Actinide",
            atomicNumber = 92,
            atomicWeight = 238.03,
            description = "A critical element in nuclear power and weapons, known for its radioactive properties."
        )
        elementsList.add(uranium)

        val neptunium = Element(
            id = 92,
            name = "Neptunium",
            symbol = "Np",
            family = "Actinide",
            atomicNumber = 93,
            atomicWeight = 237.05,
            description = "A radioactive element found in trace amounts in uranium ores, mainly used for research."
        )
        elementsList.add(neptunium)

        val plutonium = Element(
            id = 93,
            name = "Plutonium",
            symbol = "Pu",
            family = "Actinide",
            atomicNumber = 94,
            atomicWeight = 244.0,
            description = "Known for its use in nuclear weapons and reactors, it's one of the most dangerous elements."
        )
        elementsList.add(plutonium)

        val americium = Element(
            id = 94,
            name = "Americium",
            symbol = "Am",
            family = "Actinide",
            atomicNumber = 95,
            atomicWeight = 243.0,
            description = "Used in smoke detectors, this radioactive element is produced in nuclear reactors."
        )
        elementsList.add(americium)

        val curium = Element(
            id = 95,
            name = "Curium",
            symbol = "Cm",
            family = "Actinide",
            atomicNumber = 96,
            atomicWeight = 247.0,
            description = "Named after Marie Curie, it’s used in space missions for its ability to generate power."
        )
        elementsList.add(curium)

        val berkelium = Element(
            id = 96,
            name = "Berkelium",
            symbol = "Bk",
            family = "Actinide",
            atomicNumber = 97,
            atomicWeight = 247.0,
            description = "A synthetic element used in research, with no major commercial applications yet."
        )
        elementsList.add(berkelium)

        val californium = Element(
            id = 97,
            name = "Californium",
            symbol = "Cf",
            family = "Actinide",
            atomicNumber = 98,
            atomicWeight = 251.0,
            description = "Used in neutron detectors and cancer treatments, it’s incredibly rare and radioactive. It is named for the university and state of California"
        )
        elementsList.add(californium)

        val einsteinium = Element(
            98,
            "Einsteinium",
            "Es",
            "Actinide",
            99,
            252.083,
            "Named after Einstein, this element is so rare it’s mainly used for scientific research."        )
        elementsList.add(einsteinium)

        val fermium = Element(
            99,
            "Fermium",
            "Fm",
            "Actinide",
            100,
            257.0951,
            "Is a radioactive metal that is produced by nuclear reactions and is used in scientific research to study the properties of radioactive elements."
        )
        elementsList.add(fermium)

        val mendelevium = Element(
            100,
            "Mendelevium",
            "Md",
            "Actinide",
            101,
            258.0984,
            "Named after the creator of the periodic table, Dmitri Mendeleev. Used for research purposes."        )
        elementsList.add(mendelevium)

        val nobelium = Element(
            101,
            "Nobelium",
            "No",
            "Actinide",
            102,
            259.101,
            "Another synthetic element, named after Alfred Nobel, used exclusively in scientific research."        )
        elementsList.add(nobelium)

        val lawrencium = Element(
            102,
            "Lawrencium",
            "Lr",
            "Actinide",
            103,
            262.11,
            "Named after Ernest Lawrence, it’s a synthetic element with no major applications outside of research."        )
        elementsList.add(lawrencium)

        val rutherfordium = Element(
            103,
            "Rutherfordium",
            "Rf",
            "Transition Metal",
            104,
            267.122,
            "Named after the father of nuclear physics, Ernest Rutherford. Used mainly for research."        )
        elementsList.add(rutherfordium)

        val dubnium = Element(
            104,
            "Dubnium",
            "Db",
            "Transition Metal",
            105,
            270.1336,
            "Named after the city of Dubna in Russia, where it was first synthesized. Used only in research."        )
        elementsList.add(dubnium)

        val seaborgium = Element(
            105,
            "Seaborgium",
            "Sg",
            "Transition Metal",
            106,
            271.1338,
            "Named after Glenn Seaborg, a key figure in the discovery of many elements. Used in research."        )
        elementsList.add(seaborgium)

        val bohrium = Element(
            106,
            "Bohrium",
            "Bh",
            "Transition Metal",
            107,
            270.1338,
            "Named after Niels Bohr, a physicist who made key contributions to atomic theory. Used in research."        )
        elementsList.add(bohrium)

        val hassium = Element(
            107,
            "Hassium",
            "Hs",
            "Transition Metal",
            108,
            277.151,
            "Named after the German state of Hesse, it’s another element used only for research."        )
        elementsList.add(hassium)

        val meitnerium = Element(
            108,
            "Meitnerium",
            "Mt",
            "Transition Metal",
            109,
            276.151,
            "Named after Lise Meitner, a physicist who contributed to the discovery of nuclear fission. Used in research."        )
        elementsList.add(meitnerium)

        val darmstadtium = Element(
            109,
            "Darmstadtium",
            "Ds",
            "Transition Metal",
            110,
            281.164,
            "Named after the city of Darmstadt, Germany, where it was discovered. Used for research."        )
        elementsList.add(darmstadtium)

        val roentgenium = Element(
            110,
            "Roentgenium",
            "Rg",
            "Transition Metal",
            111,
            280.164,
            "Named after Wilhelm Röntgen, who discovered X-rays. A synthetic element with no commercial uses."        )
        elementsList.add(roentgenium)

        val copernicium = Element(
            111,
            "Copernicium",
            "Cn",
            "Transition Metal",
            112,
            285.177,
            "Named after the astronomer Copernicus, it’s a highly unstable synthetic element."
        )
        elementsList.add(copernicium)

        val nihonium = Element(
            112,
            "Nihonium",
            "Nh",
            "Post-Transition Metal",
            113,
            284.178,
            "Named after Japan (Nihon), this element is synthetic and highly unstable."
        )
        elementsList.add(nihonium)

        val flerovium = Element(
            113,
            "Flerovium",
            "Fl",
            "Post-Transition Metal",
            114,
            289.191,
            "Named after the Flerov Laboratory in Russia, this element has no practical applications."
        )
        elementsList.add(flerovium)

        val moscovium = Element(
            114,
            "Moscovium",
            "Mc",
            "Post-Transition Metal",
            115,
            288.192,
            "Named after Moscow, this element is unstable and mainly used in research.")
        elementsList.add(moscovium)

        val livermorium = Element(
            115,
            "Livermorium",
            "Lv",
            "Post-Transition Metal",
            116,
            293.205,
            "Named after Lawrence Livermore National Laboratory, used mainly for research purposes."
        )
        elementsList.add(livermorium)

        val tennessine = Element(
            116,
            "Tennessine",
            "Ts",
            "Halogen",
            117,
            294.211,
            "Named after the state of Tennessee, it’s a synthetic element with limited applications."
        )
        elementsList.add(tennessine)

        val oganesson = Element(
            117,
            "Oganesson",
            "Og",
            "Noble Gas",
            118,
            294.214,
            "The heaviest element on the periodic table, named after Russian scientist Yuri Oganessian."
        )
        elementsList.add(oganesson)

        return elementsList
    }
}