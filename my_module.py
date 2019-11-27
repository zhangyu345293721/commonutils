def add(arr):
    length = len(arr)
    matrix = [[0 for i in range(length)] for i in range(length)]
    for i in range(length):
        for j in range(length):
            matrix[i][j]=arr[i][j]
    return matrix
