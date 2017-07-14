package com.gft.GiFT

import spock.lang.Unroll
import spock.lang.Specification

class MaxTests extends Specification {

    @Unroll("max(#a,#b) should be #c")
    def "max tests"() {
        expect:
        Math.max(a, b) == c

        where:
        a  | b   | c
        1  | 2   | 2
        42 | -12 | 42
        42 | -12 | 42
    }

}
