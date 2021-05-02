package sgd.mn

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("sgd.mn")
		.start()
}

