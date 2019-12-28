using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace WebApplication1.Models
{
    public class Kategoria
    {
        [Key]
        public int Id { get; set; }
        public string Nazwa { get; set; }
        public int? NadKategoriaId { get; set; }
        [ForeignKey("NadKategoriaId")]
        public virtual Kategoria NadKategoria { get; set; }
        public virtual List<Kategoria> PodKategoria { get; set; }
        public virtual ICollection<Towar> Towar { get; set; }
    }
}