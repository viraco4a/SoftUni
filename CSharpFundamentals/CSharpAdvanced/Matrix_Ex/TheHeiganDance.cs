using System;

namespace TheHeiganDance
{
    class TheHeiganDance
    {
        private static bool[][] playground = new bool[15][];
        private static int playerRow = 7;
        private static int playerCol = 7;
        private static int potentialRow = 7;
        private static int potentialCol = 7;
        private static double heiganHP = 3000000;
        private static double playerHP = 18500;
        private static double cloudDamage = 3500;
        private static double eruptionDamage = 6000;
        private static bool playerDead;
        private static bool heiganDead;
        private static bool isHit;
        private static bool cloud;
        private static string deadBy = "";

        static void Main(string[] args)
        {
            InitializePlayground();
            double damage = double.Parse(Console.ReadLine());
            while (!false)
            {
                string[] attack = Console.ReadLine().Split();

                string type = attack[0];

                int attackRow = int.Parse(attack[1]);
                int attackCol = int.Parse(attack[2]);

                PlayerAttack(damage);

                if (heiganDead)
                {
                    ApplySecondCloud();
                    Console.WriteLine("Heigan: Defeated!");
                    if (playerDead)
                    {
                        Console.WriteLine($"Player: Killed by {deadBy}");
                    }
                    else
                    {
                        Console.WriteLine($"Player: {playerHP}");
                    }
                    Console.WriteLine($"Final position: {playerRow}, {playerCol}");
                    return;
                }
                else
                {
                    HeiganAttack(attackRow, attackCol, type);
                    if (playerDead)
                    {
                        Console.WriteLine($"Heigan: {heiganHP:F2}");
                        Console.WriteLine($"Player: Killed by {deadBy}");
                        Console.WriteLine($"Final position: {playerRow}, {playerCol}");
                        return;
                    }
                }
            }
        }

        private static void ApplySecondCloud()
        {
            if (cloud)
            {
                playerHP -= cloudDamage;
                if (playerHP <= 0)
                {
                    playerDead = true;
                    deadBy = "Plague Cloud";
                }
            }
            cloud = false;
        }

        private static void ApplyCloud()
        {
            playerHP -= cloudDamage;
            if (playerHP <= 0)
            {
                playerDead = true;
                deadBy = "Plague Cloud";
            }
            cloud = true;
        }

        private static void HeiganAttack(int attackRow, int attackCol, string type)
        {
            ApplySecondCloud();
            DealDamage(attackRow, attackCol, true);
            if (playground[playerRow][playerCol])
            {
                Move(-1, 0);
                if (isHit)
                {
                    Move(0, 1);
                }
                if (isHit)
                {
                    Move(1, 0);
                }
                if (isHit)
                {
                    Move(0, -1);
                }
                if (isHit)
                {
                    playerRow = potentialRow;
                    playerCol = potentialCol;
                    if (type == "Cloud")
                    {
                        ApplyCloud();
                    }
                    else
                    {
                        playerHP -= eruptionDamage;
                        if (playerHP <= 0 && !playerDead)
                        {
                            playerDead = true;
                            deadBy = "Eruption";
                        }
                    }
                }
            }
            DealDamage(attackRow, attackCol, false);
        }

        private static void DealDamage(int attackRow, int attackCol, bool isDamage)
        {
            for (int row = attackRow - 1; row <= attackRow + 1; row++)
            {
                for (int col = attackCol - 1; col <= attackCol + 1; col++)
                {
                    if (IsValid(row, col))
                    {
                        playground[row][col] = isDamage;
                    }
                }
            }
        }

        private static void Print()
        {
            for (int row = 0; row < playground.Length; row++)
            {
                for (int col = 0; col < playground[0].Length; col++)
                {
                    Console.Write(playground[row][col] + " ");
                }
                Console.WriteLine();
            }
        }

        private static void Move(int row, int col)
        {
            if (IsValid(playerRow + row, playerCol + col))
            {
                if (!playground[playerRow + row][playerCol + col])
                {
                    potentialRow = playerRow + row;
                    potentialCol = playerCol + col;
                    playerRow += row;
                    playerCol += col;
                    isHit = false;
                    return;
                }
            }

            isHit = true;
        }

        private static bool IsValid(int row, int col)
        {
            return row >= 0 && row < playground.Length && col >= 0 && col < playground[row].Length;
        }

        private static void PlayerAttack(double damage)
        {
            heiganHP -= damage;
            if (heiganHP <= 0)
            {
                heiganDead = true;
            }
        }

        private static void InitializePlayground()
        {
            for (int i = 0; i < 15; i++)
            {
                playground[i] = new bool[15];
            }
        }
    }
}
