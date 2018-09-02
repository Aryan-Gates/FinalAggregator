package com.service

import com.config.Config
import kafka.common.KafkaException
import org.apache.kafka.clients.consumer.KafkaConsumer
import java.util.*

object KafkaService {



    /**
     *  Instanting a kafka consumer

     *  @throws <consumer>, <RuntimeException>
     *  @property
     *
     *
     */

    fun getKafkaConsumer(): KafkaConsumer<String, String>? {
        val props = Properties()
        props["bootstrap.servers"] = Config.Bootstrap_servers
        props["fetch.min.bytes"] = "30000000"
        props["group.id"] = Config.Group_id
        props["enable.auto.commit"] = Config.Enable_auto_commit
        props["auto.commit.interval.ms"] = Config.Auto_commit_interval_ms
        props["key.deserializer"] = Config.Key_deserializer
        props["value.deserializer"] = Config.Value_deserializer
        props["auto.offset.reset"] = Config.Auto_offset_reset
        props["max.poll.records"] = Config.Max_poll_records
        props["max.poll.interval"] = Config.Max_poll_interval_ms
        var consumer:KafkaConsumer<String, String>? = null
        try {
            consumer = KafkaConsumer<String, String>(props)
        } catch (e: KafkaException) {
            e.printStackTrace()
        }
        /** prepare a kafka consumer
         *  @return a Kafka consumer , Map of Strings
         */
        return consumer
    }
}