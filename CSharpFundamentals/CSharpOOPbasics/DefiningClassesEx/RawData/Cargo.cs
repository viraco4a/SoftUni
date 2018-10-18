﻿using System;
using System.Collections.Generic;
using System.Text;

namespace RawData
{
    public class Cargo
    {
        private string type;
        private int weight;
        public Cargo(string type, int weight)
        {
            this.Type = type;
            this.Weight = weight;
        }

        public int Weight
        {
            get { return weight; }
            set { weight = value; }
        }

        public string Type
        {
            get { return type; }
            set { type = value; }
        }

    }
}
