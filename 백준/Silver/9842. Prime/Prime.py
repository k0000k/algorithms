def isPrime(n):
    a = [False, False] + [True] * 999998
    Primes = []
    
    for i in range(2, 999998):
        if a[i]:
            Primes.append(i)
            for j in range(i+i, 999998, i):
                a[j] = False
    
    return Primes[n-1]
    
print(isPrime(int(input())))