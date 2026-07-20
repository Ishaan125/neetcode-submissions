class LRUCache:
    def __init__(self, capacity: int):
        self._map = OrderedDict()
        self._capacity = capacity

    def get(self, key: int) -> int:
        if key not in self._map:
            return -1
        self._map.move_to_end(key)
        return self._map[key]

    def put(self, key: int, value: int) -> None:
        if key in self._map:
            self._map.move_to_end(key)
        self._map[key] = value
        
        if len(self._map) > self._capacity:
            self._map.popitem(last=False)