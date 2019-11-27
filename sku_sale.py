def my_add(timeArr,nd):
    [rows, cols] = nd.shape
    for i in range(rows):
        for j in range(cols):
            nd[i, j]+=1
    return timeArr,nd
