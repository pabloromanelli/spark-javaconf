package example3

import org.apache.spark.SparkContext._
import org.apache.spark.rdd.RDD

class Metrica {

  def calcular(rdd: RDD[Tweet]): RDD[((User, Hashtag), Int)] = {
    rdd
      .flatMap(tweet => tweet.hashtagsByMentions)
      .map(userHashtag => (userHashtag, 1))
      .reduceByKey((a, b) => a + b)
  }

}