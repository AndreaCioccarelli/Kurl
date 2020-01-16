package com.cioccarellia.kurlsample.constants

object DemoConstants {
    const val urlValidationRegexp =
        """_^(?:(?:https?|ftp)://)(?:S+(?::S*)?@)?(?:(?!10(?:.d{1,3}){3})(?!127(?:.d{1,3}){3})(?!169.254(?:.d{1,3}){2})(?!192.168(?:.d{1,3}){2})(?!172.(?:1[6-9]|2d|3[0-1])(?:.d{1,3}){2})(?:[1-9]d?|1dd|2[01]d|22[0-3])(?:.(?:1?d{1,2}|2[0-4]d|25[0-5])){2}(?:.(?:[1-9]d?|1dd|2[0-4]d|25[0-4]))|(?:(?:[a-zx{00a1}-x{ffff}0-9]+-?)*[a-zx{00a1}-x{ffff}0-9]+)(?:.(?:[a-zx{00a1}-x{ffff}0-9]+-?)*[a-zx{00a1}-x{ffff}0-9]+)*(?:.(?:[a-zx{00a1}-x{ffff}]{2,})))(?::d{2,5})?(?:/[^s]*)?${"$"}_iuS"""
}