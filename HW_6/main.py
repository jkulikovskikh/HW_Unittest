from ListComparison import ListComparision

if __name__ == '__main__':
    l = ListComparision([1, 5], [3])
    list1_average = l.calc_average([1, 5])
    print(list1_average)
    list2_average = l.calc_average([3])
    print(list2_average)
    output = l.comparison()
    print(output)

