package com.adventofcode

import com.adventofcode.Day.process
import com.adventofcode.Day.solution

fun decodeRange(encodedRange: String): LongRange {
  val (start, end) = encodedRange.split('-')
  return start.toLong()..end.toLong()
}

fun LongRange.isOverlap(other: LongRange): Boolean {
  return intersect(other).isNotEmpty()
}

object Day {

  var solution = 0L; private set

  fun process(line: String) {
    val (leftStr, rightStr) = line.split(',')
    val left = decodeRange(leftStr)
    val right = decodeRange(rightStr)
    if (left.isOverlap(right) || right.isOverlap(left)) {
      ++solution;
    }
  }
}

fun main() {
  ::main.javaClass
    .getResourceAsStream("/input")!!
    .bufferedReader()
    .forEachLine(::process)
  println(solution)
}