def solution(cap, n, deliveries, pickups):
    answer = 0

    willDelivery = 0
    willPickup = 0
    for i in range(len(deliveries)-1, -1, -1):
        willDelivery += deliveries[i]
        willPickup += pickups[i]

        while willDelivery > 0 or willPickup > 0:
            answer += ((i + 1) * 2)
            willDelivery -= cap
            willPickup -= cap
    return answer