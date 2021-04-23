import sys
from collections import deque
from pprint import pprint

OFFSET = 500001

def main():
    subin, brother = init()
    # subin, brother = 5, 17
    # subin, brother = 17, 5
    
    brother_log = get_brother_log(brother)
    print(find(brother_log, subin))


def init():
    return map(int, sys.stdin.readline().split())


def get_brother_log(brother):
    brother_log = [-1 for _ in range(OFFSET)]
    tmp = brother
    for i in range(1001):
        tmp += i
        if 500000 < tmp:
            break
        brother_log[tmp] = i
    return brother_log


def find(brother_log, subin):
    my_visited = bfs(subin)
    for i in range(OFFSET):
        for j in range(2):
            if brother_log[i] != -1:
                if my_visited[i][j] <= brother_log[i] and my_visited[i][j] % 2 == brother_log[i] % 2:
                    return brother_log[i]

    return -1


def bfs(start):
    q = deque([(start, 0)])
    my_visited = [[-1, -1] for _ in range(OFFSET)]
    my_visited[start] = [0, 0]
    while q:
        popped, cnt = q.popleft()
        for i in range(2):
            if (cnt + 1) % 2 == i:
                if popped + 1 < OFFSET and my_visited[popped + 1][i] == -1:
                    q.append((popped + 1, cnt + 1))
                    my_visited[popped + 1][i] = cnt + 1
                if 0 <= popped - 1 and my_visited[popped - 1][i] == -1:
                    q.append((popped - 1, cnt + 1))
                    my_visited[popped - 1][i] = cnt + 1
                if popped * 2 < OFFSET and my_visited[popped * 2][i] == -1:
                    q.append((popped * 2, cnt + 1))
                    my_visited[popped * 2][i] = cnt + 1
    return my_visited


if __name__ == "__main__":
    main()
