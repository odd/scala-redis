package com.redis.ds

import org.scalatest.Spec
import org.scalatest.BeforeAndAfterEach
import org.scalatest.BeforeAndAfterAll
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith


@RunWith(classOf[JUnitRunner])
class DequeSpec extends Spec 
                with ShouldMatchers
                with BeforeAndAfterEach
                with BeforeAndAfterAll {

  val r = new RedisDequeClient("localhost", 6379).mkDeque("td")

  override def beforeEach = {
    r.clear
  }

  override def afterEach = {
    r.clear
  }

  override def afterAll = {
    r.clear
  }

  describe("addFirst and check size and added element") {
    it("should add to the head of the deque") {
      r.addFirst("foo") should equal(true)
      r.peekFirst should equal(Some("foo"))
      r.addFirst("bar") should equal(true)
      r.isEmpty should equal(false)
      r.peekFirst should equal(Some("bar"))
      r.clear should equal(true)
      r.size should equal(0)
      r.isEmpty should equal(true)
      r.addFirst("foo") should equal(true)
    }
  }

  describe("addLast and check size and added element") {
    it("should add to the head of the deque") {
      r.addLast("foo") should equal(true)
      r.peekFirst should equal(Some("foo"))
      r.addLast("bar") should equal(true)
      r.peekFirst should equal(Some("foo"))
      r.size should equal(2)
      r.isEmpty should equal(false)
    }
  }

  describe("poll") {
    it("should pull out first element") {
      r.addFirst("foo") should equal(true)
      r.addFirst("bar") should equal(true)
      r.addFirst("baz") should equal(true)
      r.poll should equal(Some("baz"))
      r.poll should equal(Some("bar"))
      r.poll should equal(Some("foo"))
    }
  }

  describe("pollLast") {
    it("should pull out last element") {
      r.addFirst("foo") should equal(true)
      r.addFirst("bar") should equal(true)
      r.addFirst("baz") should equal(true)
      r.pollLast should equal(Some("foo"))
      r.pollLast should equal(Some("bar"))
      r.pollLast should equal(Some("baz"))
    }
  }
}
