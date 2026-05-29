package org.example.cm2.Exer3

class Pipeline {

    private val stages = mutableListOf<Pair<String, (List<String>) -> List<String>>>()

    fun addStage(name: String, transform: (List<String>) -> List<String>) {
        stages.add(name to transform)
    }

    fun execute(input: List<String>): List<String> {
        var result = input

        for (stage in stages) {
            result = stage.second(result)
        }

        return result
    }

    fun describe() {
        println("Pipeline stages:")
        stages.forEachIndexed { index, stage ->
            println("${index + 1}. ${stage.first}")
        }
    }
}

fun buildPipeline(configure: Pipeline.() -> Unit): Pipeline {
    val pipeline = Pipeline()
    pipeline.configure()
    return pipeline
}

fun main() {
    val logs = listOf(
        " INFO : server started ",
        " ERROR : disk full ",
        " DEBUG : checking config ",
        " ERROR : out of memory ",
        " INFO : request received ",
        " ERROR : connection timeout "
    )

    val pipeline = buildPipeline {
        addStage("Trim") { lines ->
            lines.map { it.trim() }
        }

        addStage("Filter errors") { lines ->
            lines.filter { it.contains("ERROR") }
        }

        addStage("Uppercase") { lines ->
            lines.map { it.uppercase() }
        }

        addStage("Add index") { lines ->
            lines.mapIndexed { index, line ->
                "${index + 1}. $line"
            }
        }
    }

    pipeline.describe()

    println("Result:")
    val result = pipeline.execute(logs)
    result.forEach { println(it) }
}