.class public final Lc/b/a/a/a/b;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Lc/a/c/a/i$c;


# instance fields
.field private a:Landroid/widget/Toast;

.field private b:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    const-string v0, "context"

    invoke-static {p1, v0}, Ld/d/a/a;->c(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lc/b/a/a/a/b;->b:Landroid/content/Context;

    return-void
.end method

.method public static final synthetic a(Lc/b/a/a/a/b;)Landroid/widget/Toast;
    .locals 0

    iget-object p0, p0, Lc/b/a/a/a/b;->a:Landroid/widget/Toast;

    if-eqz p0, :cond_0

    return-object p0

    :cond_0
    const-string p0, "mToast"

    invoke-static {p0}, Ld/d/a/a;->i(Ljava/lang/String;)V

    const/4 p0, 0x0

    throw p0
.end method


# virtual methods
.method public final b()V
    .locals 4

    iget-object v0, p0, Lc/b/a/a/a/b;->a:Landroid/widget/Toast;

    if-eqz v0, :cond_5

    const/4 v1, 0x0

    const-string v2, "mToast"

    if-eqz v0, :cond_4

    if-eqz v0, :cond_5

    if-eqz v0, :cond_3

    invoke-virtual {v0}, Landroid/widget/Toast;->getView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lc/b/a/a/a/b$b;

    invoke-direct {v1, p0}, Lc/b/a/a/a/b$b;-><init>(Lc/b/a/a/a/b;)V

    const-wide/16 v2, 0x3e8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_1

    :cond_1
    :goto_0
    iget-object v0, p0, Lc/b/a/a/a/b;->a:Landroid/widget/Toast;

    if-eqz v0, :cond_2

    goto :goto_1

    :cond_2
    invoke-static {v2}, Ld/d/a/a;->i(Ljava/lang/String;)V

    throw v1

    :cond_3
    invoke-static {v2}, Ld/d/a/a;->i(Ljava/lang/String;)V

    throw v1

    :cond_4
    invoke-static {v2}, Ld/d/a/a;->i(Ljava/lang/String;)V

    throw v1

    :cond_5
    :goto_1
    return-void
.end method

.method public f(Lc/a/c/a/h;Lc/a/c/a/i$d;)V
    .locals 16

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    sget-object v3, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    const-string v5, "call"

    invoke-static {v1, v5}, Ld/d/a/a;->c(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v5, "result"

    invoke-static {v2, v5}, Ld/d/a/a;->c(Ljava/lang/Object;Ljava/lang/String;)V

    iget-object v5, v1, Lc/a/c/a/h;->a:Ljava/lang/String;

    if-nez v5, :cond_0

    goto/16 :goto_8

    :cond_0
    invoke-virtual {v5}, Ljava/lang/String;->hashCode()I

    move-result v6

    const v7, -0x720fded6

    const-string v8, "mToast"

    const/4 v9, 0x0

    if-eq v6, v7, :cond_4

    const v1, -0x5185d186

    if-eq v6, v1, :cond_1

    goto/16 :goto_8

    :cond_1
    const-string v1, "cancel"

    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1c

    iget-object v1, v0, Lc/b/a/a/a/b;->a:Landroid/widget/Toast;

    if-eqz v1, :cond_3

    if-eqz v1, :cond_2

    invoke-virtual {v1}, Landroid/widget/Toast;->cancel()V

    goto :goto_0

    :cond_2
    invoke-static {v8}, Ld/d/a/a;->i(Ljava/lang/String;)V

    throw v9

    :cond_3
    :goto_0
    invoke-interface {v2, v3}, Lc/a/c/a/i$d;->b(Ljava/lang/Object;)V

    goto/16 :goto_9

    :cond_4
    const-string v6, "showToast"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1c

    const-string v5, "msg"

    invoke-virtual {v1, v5}, Lc/a/c/a/h;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "length"

    invoke-virtual {v1, v6}, Lc/a/c/a/h;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "gravity"

    invoke-virtual {v1, v7}, Lc/a/c/a/h;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    const-string v10, "bgcolor"

    invoke-virtual {v1, v10}, Lc/a/c/a/h;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/Number;

    const-string v11, "textcolor"

    invoke-virtual {v1, v11}, Lc/a/c/a/h;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/Number;

    const-string v12, "fontSize"

    invoke-virtual {v1, v12}, Lc/a/c/a/h;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Number;

    invoke-virtual {v7}, Ljava/lang/String;->hashCode()I

    move-result v12

    const v13, -0x514d33ab

    if-eq v12, v13, :cond_6

    const v13, 0x1c155

    if-eq v12, v13, :cond_5

    goto :goto_1

    :cond_5
    const-string v12, "top"

    invoke-virtual {v7, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_7

    const/16 v7, 0x30

    goto :goto_2

    :cond_6
    const-string v12, "center"

    invoke-virtual {v7, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_7

    const/16 v7, 0x11

    goto :goto_2

    :cond_7
    :goto_1
    const/16 v7, 0x50

    :goto_2
    const-string v12, "long"

    invoke-static {v6, v12}, Ld/d/a/a;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v6

    const/16 v12, 0x1e

    if-eqz v10, :cond_e

    if-ge v4, v12, :cond_e

    iget-object v13, v0, Lc/b/a/a/a/b;->b:Landroid/content/Context;

    const-string v14, "layout_inflater"

    invoke-virtual {v13, v14}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v13

    if-eqz v13, :cond_d

    check-cast v13, Landroid/view/LayoutInflater;

    sget v14, Lc/b/a/a/a/e;->a:I

    invoke-virtual {v13, v14, v9}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v13

    sget v14, Lc/b/a/a/a/d;->a:I

    invoke-virtual {v13, v14}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/TextView;

    const-string v15, "text"

    invoke-static {v14, v15}, Ld/d/a/a;->b(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v14, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    const/16 v5, 0x15

    if-lt v4, v5, :cond_9

    iget-object v5, v0, Lc/b/a/a/a/b;->b:Landroid/content/Context;

    sget v15, Lc/b/a/a/a/c;->a:I

    invoke-virtual {v5, v15}, Landroid/content/Context;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    if-eqz v5, :cond_8

    const-string v15, "context.getDrawable(R.drawable.corner)!!"

    goto :goto_3

    :cond_8
    invoke-static {}, Ld/d/a/a;->f()V

    throw v9

    :cond_9
    iget-object v5, v0, Lc/b/a/a/a/b;->b:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v15, Lc/b/a/a/a/c;->a:I

    invoke-virtual {v5, v15}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    const-string v15, "context.resources.getDrawable(R.drawable.corner)"

    :goto_3
    invoke-static {v5, v15}, Ld/d/a/a;->b(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v10}, Ljava/lang/Number;->intValue()I

    move-result v10

    sget-object v15, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v5, v10, v15}, Landroid/graphics/drawable/Drawable;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v14, v5}, Landroid/widget/TextView;->setBackground(Landroid/graphics/drawable/Drawable;)V

    if-eqz v1, :cond_a

    invoke-virtual {v1}, Ljava/lang/Number;->floatValue()F

    move-result v1

    invoke-virtual {v14, v1}, Landroid/widget/TextView;->setTextSize(F)V

    :cond_a
    if-eqz v11, :cond_b

    invoke-virtual {v11}, Ljava/lang/Number;->intValue()I

    move-result v1

    invoke-virtual {v14, v1}, Landroid/widget/TextView;->setTextColor(I)V

    :cond_b
    new-instance v1, Landroid/widget/Toast;

    iget-object v5, v0, Lc/b/a/a/a/b;->b:Landroid/content/Context;

    invoke-direct {v1, v5}, Landroid/widget/Toast;-><init>(Landroid/content/Context;)V

    iput-object v1, v0, Lc/b/a/a/a/b;->a:Landroid/widget/Toast;

    invoke-virtual {v1, v6}, Landroid/widget/Toast;->setDuration(I)V

    iget-object v1, v0, Lc/b/a/a/a/b;->a:Landroid/widget/Toast;

    if-eqz v1, :cond_c

    invoke-virtual {v1, v13}, Landroid/widget/Toast;->setView(Landroid/view/View;)V

    goto :goto_4

    :cond_c
    invoke-static {v8}, Ld/d/a/a;->i(Ljava/lang/String;)V

    throw v9

    :cond_d
    new-instance v1, Ld/b;

    const-string v2, "null cannot be cast to non-null type android.view.LayoutInflater"

    invoke-direct {v1, v2}, Ld/b;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_e
    iget-object v10, v0, Lc/b/a/a/a/b;->b:Landroid/content/Context;

    invoke-static {v10, v5, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v5

    const-string v6, "Toast.makeText(context, mMessage, mDuration)"

    invoke-static {v5, v6}, Ld/d/a/a;->b(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object v5, v0, Lc/b/a/a/a/b;->a:Landroid/widget/Toast;

    if-ge v4, v12, :cond_12

    if-eqz v5, :cond_11

    :try_start_0
    invoke-virtual {v5}, Landroid/widget/Toast;->getView()Landroid/view/View;

    move-result-object v5

    if-eqz v5, :cond_10

    const v6, 0x102000b

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    const-string v6, "mToast.view!!.findViewById(android.R.id.message)"

    invoke-static {v5, v6}, Ld/d/a/a;->b(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v5, Landroid/widget/TextView;

    if-eqz v1, :cond_f

    invoke-virtual {v1}, Ljava/lang/Number;->floatValue()F

    move-result v1

    invoke-virtual {v5, v1}, Landroid/widget/TextView;->setTextSize(F)V

    :cond_f
    if-eqz v11, :cond_12

    invoke-virtual {v11}, Ljava/lang/Number;->intValue()I

    move-result v1

    invoke-virtual {v5, v1}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_4

    :cond_10
    invoke-static {}, Ld/d/a/a;->f()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    throw v9

    :catch_0
    nop

    goto :goto_4

    :cond_11
    :try_start_1
    invoke-static {v8}, Ld/d/a/a;->i(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    throw v9

    :cond_12
    :goto_4
    if-ge v4, v12, :cond_18

    const/4 v1, 0x0

    const/16 v4, 0x11

    if-eq v7, v4, :cond_16

    const/16 v4, 0x64

    const/16 v5, 0x30

    if-eq v7, v5, :cond_14

    iget-object v5, v0, Lc/b/a/a/a/b;->a:Landroid/widget/Toast;

    if-eqz v5, :cond_13

    goto :goto_5

    :cond_13
    invoke-static {v8}, Ld/d/a/a;->i(Ljava/lang/String;)V

    throw v9

    :cond_14
    iget-object v5, v0, Lc/b/a/a/a/b;->a:Landroid/widget/Toast;

    if-eqz v5, :cond_15

    :goto_5
    invoke-virtual {v5, v7, v1, v4}, Landroid/widget/Toast;->setGravity(III)V

    goto :goto_6

    :cond_15
    invoke-static {v8}, Ld/d/a/a;->i(Ljava/lang/String;)V

    throw v9

    :cond_16
    iget-object v4, v0, Lc/b/a/a/a/b;->a:Landroid/widget/Toast;

    if-eqz v4, :cond_17

    invoke-virtual {v4, v7, v1, v1}, Landroid/widget/Toast;->setGravity(III)V

    goto :goto_6

    :cond_17
    invoke-static {v8}, Ld/d/a/a;->i(Ljava/lang/String;)V

    throw v9

    :cond_18
    :goto_6
    iget-object v1, v0, Lc/b/a/a/a/b;->b:Landroid/content/Context;

    instance-of v4, v1, Landroid/app/Activity;

    if-eqz v4, :cond_1a

    if-eqz v1, :cond_19

    check-cast v1, Landroid/app/Activity;

    new-instance v4, Lc/b/a/a/a/b$a;

    invoke-direct {v4, v0}, Lc/b/a/a/a/b$a;-><init>(Lc/b/a/a/a/b;)V

    invoke-virtual {v1, v4}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_7

    :cond_19
    new-instance v1, Ld/b;

    const-string v2, "null cannot be cast to non-null type android.app.Activity"

    invoke-direct {v1, v2}, Ld/b;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_1a
    iget-object v1, v0, Lc/b/a/a/a/b;->a:Landroid/widget/Toast;

    if-eqz v1, :cond_1b

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    :goto_7
    invoke-virtual/range {p0 .. p0}, Lc/b/a/a/a/b;->b()V

    goto/16 :goto_0

    :cond_1b
    invoke-static {v8}, Ld/d/a/a;->i(Ljava/lang/String;)V

    throw v9

    :cond_1c
    :goto_8
    invoke-interface/range {p2 .. p2}, Lc/a/c/a/i$d;->c()V

    :goto_9
    return-void
.end method
