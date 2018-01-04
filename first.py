class AB:
    def factors(self, n):
        result = []

        for i in range(1, n + 1):
            if n % i == 0:
                result.append(i)
        print 'factors for', n, result
        return result

    def createString(self, n, k):
        if k == 0:
            return 'B' * n
        for a in self.factors(k):
            b = k / a
            padding = n - a - b
            print padding, a, b
            if padding >= 0:
                return 'B' * padding + 'A' * a + 'B' * b
        print 'returning empty'
        return ''
