import sys
from collections import deque
from pprint import pprint

dirs = (
    (-1, 0),
    (0, -1),
    (1, 0),
    (0, 1),
)


def main():
    R, C, lake = init()
    # R, C, lake = 8, 17, [
    #     ['.', '.', '.', 'X', 'X', 'X', 'X', 'X', 'X', '.', '.', 'X', 'X', '.', 'X', 'X', 'X'],
    #     ['.', '.', '.', '.', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '.', 'X', 'X', 'X'],
    #     ['.', '.', '.', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '.', '.'],
    #     ['.', '.', 'X', 'X', 'X', 'X', 'X', '.', 'L', 'X', 'X', 'X', 'X', 'X', 'X', '.', '.'],
    #     ['.', 'X', 'X', 'X', 'X', 'X', 'X', '.', '.', 'X', 'X', 'X', 'X', 'X', 'X', '.', '.'],
    #     ['X', 'X', 'X', 'X', 'X', 'X', 'X', '.', '.', '.', 'X', 'X', 'X', 'X', '.', '.', '.'],
    #     ['.', '.', 'X', 'X', 'X', 'X', 'X', '.', '.', '.', 'X', 'X', 'X', '.', '.', '.', '.'],
    #     ['.', '.', '.', '.', 'X', 'X', 'X', 'X', 'X', '.', 'X', 'X', 'X', 'L', '.', '.', '.']
    # ]
    # print(lake)

    lake, birds = find_birds_and_remove_birds(lake)
    # print(birds)

    print(get_duration(lake, birds))


def init():
    R, C = map(int, sys.stdin.readline().split())
    lake = [[] for _ in range(R)]
    for i in range(R):
        lake[i] = list(sys.stdin.readline().rstrip())
    return R, C, lake


def find_birds_and_remove_birds(lake):
    birds = []
    for i, r in enumerate(lake):
        for j, c in enumerate(r):
            if c == 'L':
                birds.append((i, j))
                lake[i][j] = '.'
                if len(birds) == 2:
                    break
    return lake, birds


def get_duration(lake, birds):
    if bfs_birds_meet(lake, birds):
        return 0
    cnt = 1
    while True:
        if bfs_melt_ready(lake, cnt) and bfs_birds_meet(lake, birds):
            return cnt
        cnt += 1


def bfs_birds_meet(lake, birds):
    visited = [[False for _ in range(len(lake[0]))] for _ in range(len(lake))]
    q = deque([birds[0]])
    visited[birds[0][0]][birds[0][1]] = True
    while q:
        r, c = q.popleft()
        for i in range(4):
            nr, nc = r + dirs[i][0], c + dirs[i][1]
            if not (0 <= nr < len(lake) and 0 <= nc < len(lake[0])):
                continue
            if nr == birds[1][0] and nc == birds[1][1]:
                return True
            if not visited[nr][nc] and lake[nr][nc] != 'X':
                q.append((nr, nc))
                visited[nr][nc] = True
    return False


def bfs_melt_ready(lake, t):
    visited = [[False for _ in range(len(lake[0]))] for _ in range(len(lake))]
    can_meet = False
    for i in range(len(lake)):
        for j in range(len(lake[0])):
            if not visited[i][j] and lake[i][j] == 'X':
                can_meet |= bfs_melt_start(lake, visited, i, j, t)
    return can_meet


def bfs_melt_start(lake, visited2, sr, sc, t):
    visited1 = [[False for _ in range(len(lake[0]))] for _ in range(len(lake))]
    visited1[sr][sc] = True
    visited2[sr][sc] = True
    can_meet = False
    q = deque([(sr, sc)])
    while q:
        r, c = q.popleft()
        boundary_cnt = 0
        for i in range(4):
            nr, nc = r + dirs[i][0], c + dirs[i][1]
            if not (0 <= nr < len(lake) and 0 <= nc < len(lake[0])):
                continue
            if lake[nr][nc] == '.' or (isinstance(lake[nr][nc], int) and lake[nr][nc] < t):
                boundary_cnt += 1
                continue
            if not visited1[nr][nc] and lake[nr][nc] == 'X':
                q.append((nr, nc))
                visited1[nr][nc] = True
                visited2[nr][nc] = True
        if boundary_cnt >= 1:
            lake[r][c] = t
            if boundary_cnt >= 2:
                can_meet = True
    return can_meet


if __name__ == "__main__":
    main()
