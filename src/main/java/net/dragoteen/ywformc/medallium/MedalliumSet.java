package net.dragoteen.ywformc.medallium;

import java.util.List;

public enum MedalliumSet {

    NORMAL(List.of("shogunyan", "komashura", "cabotin", "camaieul", "gorgouille")),
    Z(List.of("shogunyan", "komashura", "cabotin", "camaieul", "gorgouille", "deballerine", "savantard", "slurpent")),
    BLASTERS(List.of("shogunyan", "komashura", "cabotin", "camaieul", "gorgouille", "deballerine", "savantard", "slurpent")),
    U(List.of("shogunyan", "komashura", "cabotin", "camaieul", "gorgouille", "deballerine", "savantard", "slurpent", "saincope", "coraillinr", "asura", "roi_pourkoidon")),
    BLASTERS_2(List.of("shogunyan", "komashura", "cabotin", "camaieul", "gorgouille", "deballerine", "savantard", "slurpent", "saincope", "coraillinr", "asura", "roi_pourkoidon", "morigami_rex", "kanekui_hime"));

    private final List<String> pageIds;

    MedalliumSet(List<String> pageIds) {
        this.pageIds = pageIds;
    }

    public List<String> getPageIds() {
        return pageIds;
    }

    public String getPageId(int index) {
        return pageIds.get(index);
    }

    public int size() {
        return pageIds.size();
    }
}