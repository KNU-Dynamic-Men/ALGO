import sys
from collections import deque
from pprint import pprint

dirs = (
    (0, -1, 0),
    (0, 0, -1),
    (0, 1, 0),
    (0, 0, 1),
    (-1, 0, 0),  # down floor
    (1, 0, 0),  # up floor
)


class Position:
    def __init__(self, floor=-1, r=-1, c=-1, count=0):
        self.floor = floor
        self.r = r
        self.c = c
        self.count = count

    def __str__(self):
        return f'[{self.floor}, {self.r}, {self.c}, {self.count}]'


def main():
    while True:
        maze, L, R, C = init()
        # pprint(maze)
        if L == R == C == 0:
            return
        sp, ep = get_S_and_E(maze)
        duration = find_end(maze, sp, ep)
        if duration == -1:
            print("Trapped!")
        else:
            print(f"Escaped in {duration} minute(s).")


def init():
    L, R, C = map(int, sys.stdin.readline().split())
    maze = []
    for _ in range(L):
        floor = []
        for _ in range(R):
            floor.append(list(sys.stdin.readline().rstrip()))
        sys.stdin.readline()
        maze.append(floor)
    return maze, L, R, C


def get_S_and_E(maze):
    sp = Position()
    ep = Position()
    for i, floor in enumerate(maze):
        for j, line in enumerate(floor):
            for k, section in enumerate(line):
                if section == 'S':
                    sp.floor, sp.r, sp.c = i, j, k
                elif section == 'E':
                    ep.floor, ep.r, ep.c = i, j, k
    return sp, ep


def find_end(maze, sp, ep):
    q = deque([sp])
    while q:
        position = q.popleft()

        if is_end(position, ep):
            return position.count

        q += get_next_position(maze, position, ep)

    return -1


def get_next_position(maze, position, ep):
    result = []
    for d in dirs:
        nfloor, nr, nc = position.floor + d[0], position.r + d[1], position.c + d[2]

        if not is_inbound(maze, nfloor, nr, nc):
            continue

        if maze[nfloor][nr][nc] not in ('.', 'E'):
            continue

        maze[nfloor][nr][nc] = position.count
        result.append(Position(nfloor, nr, nc, position.count + 1))
    return result


def is_end(p1: Position, p2: Position):
    return p1.floor == p2.floor and p1.r == p2.r and p1.c == p2.c


def is_inbound(maze, nfloor, nr, nc):
    return 0 <= nfloor < len(maze) and \
           0 <= nr < len(maze[0]) and \
           0 <= nc < len(maze[0][0])


if __name__ == "__main__":
    main()
