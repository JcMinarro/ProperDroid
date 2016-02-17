package com.jcminarro.properdroid

import org.robolectric.RuntimeEnvironment
import org.robospock.RoboSpecification

class ProperDroidTest extends RoboSpecification {

    private static final boolean EXPECTED_BOOLEAN_VALUE = true
    private static final int EXPECTED_INT_VALUE = 3
    private static final long EXPECTED_LONG_VALUE = 38l
    private static final double EXPECTED_DOUBLE_VALUE = 2.55
    private static final String EXPECTED_STRING_VALUE = "Jc Miñarro"

    def "Should return properly boolean value"() {
        when:
        def booleanValue = ProperDroid.with(RuntimeEnvironment.application).getBoolean("booleanValue", Boolean.FALSE)

        then:
        booleanValue == EXPECTED_BOOLEAN_VALUE
    }

    def "Should return properly int value"() {
        when:
        def intValue = ProperDroid.with(RuntimeEnvironment.application).getInt("intValue", Integer.MAX_VALUE)

        then:
        intValue == EXPECTED_INT_VALUE
    }

    def "Should return properly double value"() {
        when:
        def doubleValue = ProperDroid.with(RuntimeEnvironment.application).getDouble("doubleValue", Double.MAX_VALUE)

        then:
        doubleValue == EXPECTED_DOUBLE_VALUE
    }

    def "Should return properly long value"() {
        when:
        def longValue = ProperDroid.with(RuntimeEnvironment.application).getLong("longValue", Long.MAX_VALUE)

        then:
        longValue == EXPECTED_LONG_VALUE
    }

    def "Should return properly String value"() {
        when:
        def stringValue = ProperDroid.with(RuntimeEnvironment.application).getString("stringValue", "")

        then:
        stringValue == EXPECTED_STRING_VALUE
    }

    def "Should return fallback boolean value"() {
        when:
        def intValue = ProperDroid.with(RuntimeEnvironment.application).getBoolean("fallbackValue", Boolean.FALSE)

        then:
        intValue == Boolean.FALSE
    }

    def "Should return fallback int value"() {
        when:
        def intValue = ProperDroid.with(RuntimeEnvironment.application).getInt("fallbackValue", Integer.MAX_VALUE)

        then:
        intValue == Integer.MAX_VALUE
    }

    def "Should return fallback double value"() {
        when:
        def doubleValue = ProperDroid.with(RuntimeEnvironment.application).getDouble("fallbackValue", Double.MAX_VALUE)

        then:
        doubleValue == Double.MAX_VALUE
    }

    def "Should return fallback long value"() {
        when:
        def longValue = ProperDroid.with(RuntimeEnvironment.application).getLong("fallbackValue", Long.MAX_VALUE)

        then:
        longValue == Long.MAX_VALUE
    }

    def "Should return fallback String value"() {
        when:
        def stringValue = ProperDroid.with(RuntimeEnvironment.application).getString("fallbackValue", "")

        then:
        stringValue == ""
    }
}
