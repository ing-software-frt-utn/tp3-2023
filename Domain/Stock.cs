﻿using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain
{
    public class Stock
    {
        public Articulo articulo { get; set; }
        public Talle talle { get; set; }
        public Color color { get; set; }
        public int stock { get; set; }
    }
}
