package org.galaxio.gatling.amqp.request

import java.util.Date

import io.gatling.internal.quicklens._
import io.gatling.core.action.builder.ActionBuilder
import io.gatling.core.session.Expression

case class PublishDslBuilder(attributes: AmqpAttributes, factory: AmqpAttributes => ActionBuilder) {
  def messageId(value: Expression[String]): PublishDslBuilder =
    this.modify(_.attributes.messageProperties.messageId).setTo(Some(value))

  def priority(value: Expression[Int]): PublishDslBuilder =
    this.modify(_.attributes.messageProperties.priority).setTo(Some(value))

  def contentType(value: Expression[String]): PublishDslBuilder =
    this.modify(_.attributes.messageProperties.contentType).setTo(Some(value))

  def contentEncoding(value: Expression[String]): PublishDslBuilder =
    this.modify(_.attributes.messageProperties.contentEncoding).setTo(Some(value))

  def correlationId(value: Expression[String]): PublishDslBuilder =
    this.modify(_.attributes.messageProperties.correlationId).setTo(Some(value))

  def replyTo(value: Expression[String]): PublishDslBuilder =
    this.modify(_.attributes.messageProperties.replyTo).setTo(Some(value))

  def expiration(value: Expression[String]): PublishDslBuilder =
    this.modify(_.attributes.messageProperties.expiration).setTo(Some(value))

  def timestamp(value: Expression[Date]): PublishDslBuilder =
    this.modify(_.attributes.messageProperties.timestamp).setTo(Some(value))

  def amqpType(value: Expression[String]): PublishDslBuilder =
    this.modify(_.attributes.messageProperties.`type`).setTo(Some(value))

  def userId(value: Expression[String]): PublishDslBuilder =
    this.modify(_.attributes.messageProperties.userId).setTo(Some(value))

  def appId(value: Expression[String]): PublishDslBuilder =
    this.modify(_.attributes.messageProperties.appId).setTo(Some(value))

  def clusterId(value: Expression[String]): PublishDslBuilder =
    this.modify(_.attributes.messageProperties.clusterId).setTo(Some(value))

  def header(key: String, value: Expression[String]): PublishDslBuilder =
    this.modify(_.attributes.messageProperties.headers).using(_ + (key -> value))

  def headers(hs: (String, Expression[String])*): PublishDslBuilder =
    hs.foldLeft(this) { case (rb, (k, v)) => rb.header(k, v) }

  def build(): ActionBuilder = factory(attributes)
}
