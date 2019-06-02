n = int(input())
for i in range(n):
    line = input()
    flour = False
    eggs = False
    sugar = False
    while True:
        if line == "Bake!":
            if flour and eggs and sugar:
                print(f"Baking batch number {i + 1}...")
                break
            else:
                print("The batter should contain flour, eggs and sugar!")
                line = input()
                continue
        if line == "flour":
            flour = True
        if line == "eggs":
            eggs = True
        if line == "sugar":
            sugar = True
        line = input()