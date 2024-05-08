class UnitTest:
    def __init__(self):
        self.passes = 0
        self.fails = 0
        self.verbose = True

    def set_verbose(self, verbose):
        self.verbose = verbose

    def assert_equals(self, msg, actual, expected):
        if actual == expected:
            self.__pass(msg, actual, expected)
        else:
            self.__fail(msg, actual, expected)

    def print_summary(self):
        total = self.passes + self.fails
        percent_pass = (self.passes / total) * 100 if total != 0 else 0
        percent_fail = (self.fails / total) * 100 if total != 0 else 0

        print("---------------")
        print(f"{self.passes}/{total} tests passed ({percent_pass:.1f}%)")
        print(f"{self.fails}/{total} tests failed ({percent_fail:.1f}%)")
        print("---------------")

    def __print_details(self, msg, actual, expected):
        print(msg)
        print(f"actual: {actual}")
        print(f"expected: {expected}")

    def __pass(self, msg, actual, expected):
        if self.verbose:
            self.__print_details(msg, actual, expected)
            print("PASS")
        self.passes += 1

    def __fail(self, msg, actual, expected):
        self.__print_details(msg, actual, expected)
        print("FAIL")
        self.fails += 1
