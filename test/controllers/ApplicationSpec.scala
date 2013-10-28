package controllers

import play.api.test._

class ApplicationSpec extends PlaySpecification
{
  "Application controller" should {

    val fakeApplication = FakeApplication(withGlobal = Some(TestGlobal))

    "return the index page" in new WithApplication(fakeApplication) {
      assertResponse("/", """Check out <a href="/game">the latest game</a>.""")
    }

    "return the game page" in new WithApplication(fakeApplication) {
      assertResponse("/game", """Game start""")
    }
  }

  def assertResponse(url: String, content: String) = {
    val result = route(FakeRequest(GET, url)).get
    status(result) must equalTo(OK)
    contentType(result) must beSome("text/html")
    charset(result) must beSome("utf-8")
    contentAsString(result) must contain(content)
  }
}
