package org.virtuslab.akkasaferserializer

import akka.util.ByteString
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should
import org.virtuslab.akkasaferserializer.compiler.TestCompiler

import java.io.{BufferedReader, InputStreamReader}
import java.nio.charset.StandardCharsets
import java.util.stream.Collectors

class PluginComponentSpec extends AnyFlatSpecLike with should.Matchers {
  private def getResourceAsString(name: String) =
    new BufferedReader(new InputStreamReader(getClass.getClassLoader.getResourceAsStream(name), StandardCharsets.UTF_8))
      .lines()
      .collect(Collectors.joining("\n"))

  private val serCode = getResourceAsString("MySer.scala")

  "Plugin" should "correctly traverse from Behavior to serializer trait" in {
    val out = TestCompiler.compileCode(List(serCode, getResourceAsString("SingleBehaviorYes.scala")))
    out should have size 0
  }

  it should "detect lack of serializer trait" in {
    val out = TestCompiler.compileCode(List(serCode, getResourceAsString("SingleBehaviorNo.scala")))
    out should include("error")
  }

}
